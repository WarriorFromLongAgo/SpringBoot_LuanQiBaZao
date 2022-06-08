package com.xuegao.luanqibazao_1.utils.jsoup;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import com.xuegao.luanqibazao_1.utils.audio.AudioUtils;
import com.xuegao.luanqibazao_1.utils.document.DocumentUtils;
import com.xuegao.luanqibazao_1.utils.video.VideoUtils;
import com.xuegao.luanqibazao_1.utils.zip.ZipUtils;
import io.micrometer.core.instrument.util.JsonUtils;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsoupUtilsV2 {
    private static final Logger log = LoggerFactory.getLogger(JsoupUtilsV2.class);

    private static final Set<String> FILTER_SET = Sets.newHashSet("../", "__MACOSX/");

    public static Map<String, List<FileNameUrl>> getUrl(String url, String downKey, String folderKey) throws IOException {
        Map<String, List<FileNameUrl>> resultMap = new HashMap<>(20);
        List<FileNameUrl> downList = new ArrayList<>(10);
        List<FileNameUrl> folderList = new ArrayList<>(10);
        resultMap.put(downKey, downList);
        resultMap.put(folderKey, folderList);

        Document doc = Jsoup.connect(url).get();
        log.info("[SpringBoot_LuanQiBaZao][JsoupUtilsV2][getUrl][doc={}]", JSON.toJSONString(doc));
        Elements newsHeadlines = doc.select("a");
        for (Element link : newsHeadlines) {
            String relHref = link.attr("href");
            if (FILTER_SET.contains(relHref)) {
                continue;
            }
            String absHref = link.attr("abs:href");
            String absHrefDecode = URLDecoder.decode(absHref, String.valueOf(StandardCharsets.UTF_8));
            log.info("[SpringBoot_LuanQiBaZao][JsoupUtilsV2][getUrl][relHref={}][absHref={}]", relHref, absHref);
            if (relHref.endsWith("/")){
                FileNameUrl fileNameUrl = new FileNameUrl();
                fileNameUrl
                continue;
            }
        }
        return resultMap;
    }
}
