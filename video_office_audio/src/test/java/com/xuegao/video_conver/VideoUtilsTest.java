package com.xuegao.video_conver;

import com.xuegao.video_conver.audio.VideoUtils;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.*;
import java.io.File;

import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * 测试视频工具
 *
 * @author huangxuyang
 * @since 2019/3/21
 */
public class VideoUtilsTest {

    @Test
    public void thumbnail() {
        // 截取视频中的某一帧画面
        File source = new File("target/test-classes/material/testVideo.mov");
        File target = new File("testVideoThumbnail.png");
        VideoUtils.thumbnail(source, target, 1.5F);
        assertTrue("视频缩略图应该被生成", target.exists());
        assertTrue("视频缩略图大小应该大于0", target.length() > 0);
    }

    @Test
    public void videoTime() {
        try {

            System.out.println(getLength("E:\\success.mp3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double getLength(String path) throws Exception {
        File file = new File(path);
        AudioInputStream stream;
        stream = AudioSystem.getAudioInputStream(file);
        AudioFormat format = stream.getFormat();
        if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
            format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format
                    .getSampleRate(), format.getSampleSizeInBits() * 2, format
                    .getChannels(), format.getFrameSize() * 2, format
                    .getFrameRate(), true); // big endian
            stream = AudioSystem.getAudioInputStream(format, stream);
        }
        DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat(),
                ((int) stream.getFrameLength() * format.getFrameSize()));
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.close();
        return clip.getBufferSize()
                / (clip.getFormat().getFrameSize() * clip.getFormat()
                .getFrameRate());
    }
}