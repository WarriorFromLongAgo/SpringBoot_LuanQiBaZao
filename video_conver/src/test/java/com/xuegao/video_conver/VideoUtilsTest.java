package com.xuegao.video_conver;

import com.xuegao.video_conver.audio.VideoUtils;
import org.junit.jupiter.api.Test;

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
}