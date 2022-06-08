package com.xuegao.luanqibazao_1.utils.jsoup;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import com.xuegao.luanqibazao_1.utils.audio.AudioUtils;
import com.xuegao.luanqibazao_1.utils.document.DocumentUtils;
import com.xuegao.luanqibazao_1.utils.video.VideoUtils;
import com.xuegao.luanqibazao_1.utils.zip.ZipUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JsoupUtils {
    private static final Logger log = LoggerFactory.getLogger(JsoupUtils.class);

    private Set<String> filterSet = Sets.newHashSet("../", "__MACOSX/");

    public static List<FileNameUrl> getHtml(String url) throws IOException {
        List<FileNameUrl> fileNameUrlList = new ArrayList<>(10);
        // 构造URL
        Document doc = Jsoup.connect(url).get();
        log.info("[SpringBoot_LuanQiBaZao][JsoupUtils][getHtml][doc={}]", JSON.toJSONString(doc));
        Elements newsHeadlines = doc.select("a");
        for (Element link : newsHeadlines) {
            String relHref = link.attr("href");
            if (relHref.endsWith("../")) {
                continue;
            }
            String absHref = link.attr("abs:href");
            String absHrefDecode = URLDecoder.decode(absHref, String.valueOf(StandardCharsets.UTF_8));

            if (!ZipUtils.isCompressByFileName(relHref)
                    && !AudioUtils.isAudioByFileName(relHref)
                    && !DocumentUtils.isDocumentByFileName(relHref)
                    && !VideoUtils.isVideoByFileName(relHref)) {
                String newUrl = absHrefDecode.replace(" ", "%20");
                List<FileNameUrl> html = getHtml(newUrl);
                fileNameUrlList.addAll(html);
                continue;
            }
            System.out.println("======================================");
            String fileName = URLDecoder.decode(relHref, String.valueOf(StandardCharsets.UTF_8));
            FileNameUrl fileNameUrl = new FileNameUrl();
            fileNameUrl.setFileName(fileName);
            fileNameUrl.setUrl(absHref);
            log.info("[SpringBoot_LuanQiBaZao][JsoupUtils][getHtml][fileNameUrl={}]", JSON.toJSONString(fileNameUrl));
            System.out.println("======================================");
            fileNameUrlList.add(fileNameUrl);
        }
        return fileNameUrlList;
    }

    public static List<FileNameUrl> getHtmlV2(String url) throws IOException {
        // 构造URL
        Document doc = Jsoup.connect(url).get();
        log.info("[SpringBoot_LuanQiBaZao][JsoupUtils][getHtml][doc={}]", JSON.toJSONString(doc));
        Elements newsHeadlines = doc.select("a");
        for (Element link : newsHeadlines) {
            String relHref = link.attr("href");
            if (relHref.endsWith("../")) {
                continue;
            }

            String absHref = link.attr("abs:href");
            String absHrefDecode = URLDecoder.decode(absHref, String.valueOf(StandardCharsets.UTF_8));

            String newUrl = absHrefDecode.replace(" ", "%20");
            if (ZipUtils.isCompressByFileName(newUrl)) {
                // 下载
            } else {
                List<FileNameUrl> fileNameUrlList = getHtml(newUrl);
                log.info("[SpringBoot_LuanQiBaZao][JsoupUtils][getHtmlV2][={}]", JSON.toJSONString(fileNameUrlList));

            }
        }

        return null;
    }
}
