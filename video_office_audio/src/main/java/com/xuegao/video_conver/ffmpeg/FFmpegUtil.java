package com.xuegao.video_conver.ffmpeg;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.video_conver.ffmpeg
 * <br/> @ClassName：FFmpegUtil
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/30 11:18
 */
public class FFmpegUtil {
    private FFmpegUtil() {
    }

    public static final String FFMPEG_PATH = "/app/ffmpeg/bin/";

    /**
     * 默认缩略图后缀
     */
    public static final String THUMBNAIL_SUFFIX = ".thumbnail";

    /**
     * mp4后缀
     */
    public static final String MP4_SUFFIX = ".mp4";

    /**
     * 默认视频动态码率
     */
    public static final String DEFAULT_QSCALE = "6";

    private static final Logger logger = LoggerFactory.getLogger(FFmpegUtil.class);

    /**
     * 生成视频缩略图,默认放在视频文件同目录下，文件名为视频文件名+".thumbnail"
     */
    public static Boolean generateThumb(String videoFile) {

        return generateThumb(videoFile, videoFile + THUMBNAIL_SUFFIX);
    }

    /**
     * 生成视频缩略图
     * @param videoFile 源视频文件地址
     * @param imageFile 输出图片地址
     */
    public static Boolean generateThumb(String videoFile, String imageFile) {

        return generateThumb(videoFile, imageFile, null, null);

    }

    /**
     * 生成视频缩略图
     * @param videoFile 源视频文件地址
     * @param imageFile 输出图片地址
     * @param timeStr   截取视频时间点,格式为hh:mm:ss,为空时默认值为00:00:00
     * @param iamgeSize 输出图片大小,格式为width*height,为空时以视频宽高为准
     */
    public static Boolean generateThumb(String videoFile, String imageFile,
                                        String timeStr, String iamgeSize) {
        if (!StringUtils.hasText(timeStr)) {
            timeStr = "00:00:00";
        }
        ProcessBuilder processBuilder;
        if (StringUtils.hasText(iamgeSize)) {
            processBuilder = new ProcessBuilder("ffmpeg", "-i", videoFile,
                    "-y", "-f", "image2", "-ss", timeStr, "-vframes", "1",
                    "-s", iamgeSize, imageFile);
        } else {
            processBuilder = new ProcessBuilder("ffmpeg", "-i", videoFile,
                    "-y", "-f", "image2", "-ss", timeStr, "-vframes", "1",
                    imageFile);
        }

        return processCommand(processBuilder);
    }

    /**
     * 执行命令
     */
    public static Boolean processCommand(ProcessBuilder processBuilder) {
        Boolean status = true;
        InputStream stderr = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            List<String> commandList = processBuilder.command();
            StringBuilder commandStrBuf = new StringBuilder();
            for (String commandItem : commandList) {
                commandStrBuf.append(commandItem).append(" ");
            }
            String cmdStr = commandStrBuf.toString();
            final Process proc = Runtime.getRuntime().exec(FFMPEG_PATH + cmdStr);

            //处理InputStream的线程
            new Thread() {
                @Override
                public void run() {
                    BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                    String line = null;
                    try {
                        while ((line = in.readLine()) != null) {
                            logger.info("output: " + line);
                        }
                        in.close();

                    } catch (IOException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }.start();

            new Thread() {
                @Override
                public void run() {
                    BufferedReader err = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
                    String line = null;

                    try {
                        while ((line = err.readLine()) != null) {
                            logger.info("err: " + line);
                        }
                        err.close();
                    } catch (IOException e) {
                        logger.info(e.getMessage(), e);
                    }

                }
            }.start();


            proc.waitFor();
            stderr = proc.getErrorStream();
            isr = new InputStreamReader(stderr);
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                logger.info(line);
            }
        } catch (Exception t) {
            status = false;
            logger.error("ffmpeg命令执行异常", t);
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(isr);
            IOUtils.closeQuietly(stderr);
        }
        return status;
    }

    /**
     * 执行命令
     */
    public static Boolean processCommand(List<String> cmdList) {

        ProcessBuilder processBuilder = new ProcessBuilder(cmdList);
        return processCommand(processBuilder);
    }

    /**
     * 非MP4格式视频转MP4
     */
    public static Boolean video2Mp4(String inputFile, String outFile,
                                    boolean needCover) {

        return processCommand(FFmpegCmdGenerator.getVideo2Mp4Cmd(inputFile, outFile, needCover));
    }

    /**
     * 非MP4格式视频转MP4
     */
    public static Boolean video2Mp4(String inputFile) {

        //转码MP4
        processCommand(FFmpegCmdGenerator.getVideo2Mp4Cmd(inputFile, null, true));
        //生成缩略图
        generateThumb(inputFile + MP4_SUFFIX);

        return true;
    }
}