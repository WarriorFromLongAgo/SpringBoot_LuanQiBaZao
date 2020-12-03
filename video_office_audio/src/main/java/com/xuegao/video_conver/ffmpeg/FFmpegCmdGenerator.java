package com.xuegao.video_conver.ffmpeg;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.video_conver.ffmpeg
 * <br/> @ClassName：FFmpegCmdGenerator
 * <br/> @Description：ffmpeg 命令生成器
 * <br/> @author：xuegao
 * <br/> @date：2020/11/30 11:17
 */
public class FFmpegCmdGenerator {

    private FFmpegCmdGenerator() {}

    private static String ffmpeg = "ffmpeg";

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

    public static List<String> getGenThumbCmd(String inputFile, String outFile,
                                              String timeStr, String iamgeSize, boolean needCover) {

        List<String> commandList = new ArrayList<String>();

        commandList.add(ffmpeg);
        commandList.add("-i");
        commandList.add(inputFile);

        if (needCover) {
            commandList.add("-y");
        }
        commandList.add("-f");
        commandList.add("image2");

        commandList.add("-ss");
        if (!StringUtils.hasText(timeStr)) {
            timeStr = "00:00:00";
        }
        commandList.add(timeStr);

        if (StringUtils.hasText(iamgeSize)) {
            commandList.add("-s");
            commandList.add(iamgeSize);
        }

        if (!StringUtils.hasText(outFile)) {
            outFile = inputFile + THUMBNAIL_SUFFIX;
        }
        commandList.add(outFile);
        return commandList;
    }

    /**
     * 获取wmv转MP4命令
     *
     * @param inputFile
     *            输入文件地址
     * @param outFile
     *            输出文件地址
     * @param needCover
     *            是否覆盖已存在文件
     * @return
     */
    public static List<String> getWmv2Mp4Cmd(String inputFile, String outFile,
                                             boolean needCover) {
        List<String> commandList = new ArrayList<String>();

        commandList.add(ffmpeg);
        commandList.add("-i");
        commandList.add(inputFile);

        if (needCover) {
            commandList.add("-y");
        }

        commandList.add("-ar");
        commandList.add("44100");

        commandList.add("-r");
        commandList.add("19.97");

        commandList.add("-s");
        commandList.add("1280x720");

        commandList.add("-vcodec");
        commandList.add("libx264");

//		commandList.add("-qscale");
//		commandList.add(DEFAULT_QSCALE);

//		commandList.add("-acodec");
//		commandList.add("aac");

        if (!StringUtils.hasText(outFile)) {
            outFile = inputFile + MP4_SUFFIX;
        }
        commandList.add(outFile);
        return commandList;
    }

    /**
     * @param inputFile
     *            输入文件地址
     * @param outFile
     *            输出文件地址
     * @param qscale
     *            取值0.01-255，越小质量越好，为空时默认取值6
     * @param needCover
     *            是否覆盖已存在文件
     * @return
     */
    public static List<String> getavi2Mp4Cmd(String inputFile, String outFile,
                                             String qscale, boolean needCover) {
        List<String> commandList = new ArrayList<String>();

        commandList.add(ffmpeg);
        commandList.add("-i");
        commandList.add(inputFile);

        if (needCover) {
            commandList.add("-y");
        }
        commandList.add("-vcodec");
        commandList.add("mpeg4");

        commandList.add("-qscale");
        if (!StringUtils.hasText(qscale)) {
            qscale = DEFAULT_QSCALE;
        }
        commandList.add(qscale);

        commandList.add("-acodec");
        commandList.add("aac");

        if (!StringUtils.hasText(outFile)) {
            outFile = inputFile + MP4_SUFFIX;
        }
        commandList.add(outFile);
        return commandList;
    }

    /**
     * flv转Mp4命令
     *
     * @param inputFile
     *            输入文件地址
     * @param outFile
     *            输出文件地址
     * @param needCover
     *            是否覆盖已存在文件
     * @return
     */
    public static List<String> getflv2Mp4Cmd(String inputFile, String outFile,
                                             boolean needCover) {
        List<String> commandList = new ArrayList<String>();

        commandList.add(ffmpeg);
        commandList.add("-i");
        commandList.add(inputFile);

        if (needCover) {
            commandList.add("-y");
        }

        if (!StringUtils.hasText(outFile)) {
            outFile = inputFile + MP4_SUFFIX;
        }
        commandList.add(outFile);
        return commandList;
    }

    /**
     * swf转Mp4命令
     *
     * @param inputFile
     *            输入文件地址
     * @param outFile
     *            输出文件地址
     * @param needCover
     *            是否覆盖已存在文件
     * @return
     */
    public static List<String> getswf2Mp4Cmd(String inputFile, String outFile,
                                             boolean needCover) {
        List<String> commandList = new ArrayList<String>();

        commandList.add(ffmpeg);
        commandList.add("-i");
        commandList.add(inputFile);

        if (needCover) {
            commandList.add("-y");
        }

        if (!StringUtils.hasText(outFile)) {
            outFile = inputFile + MP4_SUFFIX;
        }
        commandList.add(outFile);
        return commandList;
    }

    /**
     * 非mp4视频转MP4命令
     * @param inputFile
     * @param outFile
     * @param needCover
     * @return
     */
    public static List<String> getVideo2Mp4Cmd(String inputFile, String outFile,
                                               boolean needCover) {

//		if(inputFile.toLowerCase().endsWith(".mp4")){
//			return null;
//		}else if(inputFile.toLowerCase().endsWith(".wmv")){
        return getWmv2Mp4Cmd(inputFile, outFile, needCover);
//		}else if(inputFile.toLowerCase().endsWith(".avi")){
//			return getavi2Mp4Cmd(inputFile, outFile, null, needCover);
//		}else if(inputFile.toLowerCase().endsWith(".flv")){
//			return getflv2Mp4Cmd(inputFile, outFile, needCover);
//		}else if(inputFile.toLowerCase().endsWith(".swf")){
//			return getswf2Mp4Cmd(inputFile, outFile, needCover);
//		}else{
//			return null;
//		}
//
    }
}