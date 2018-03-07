package com.crawler.job.gifdx.net;

import com.crawler.job.CommonCrawler;
import com.crawler.model.Pic;
import com.crawler.service.PicService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * Created by admin on 2018/3/6.
 */
public class CrawlerImpl extends CommonCrawler{

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    PicService picService;

    @Override
    public void doCrawlOnePage(String url) throws Exception{
        System.out.println("start crawl => " + url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if(response.getStatusCodeValue() != 200) return;
        String html = response.getBody();
        Document document = Jsoup.parse(html);
        //#post_container > li:nth-child(2) > div.thumbnail > a > img
        Elements list = document.select("#post_container div.thumbnail > a > img");
        for(Element e : list){
            String picUrl = e.attributes().get("src");
            String picRemarks = e.attributes().get("alt");
            Pic pic = new Pic();
            pic.setTitle(picRemarks);
            pic.setRemarks(picRemarks);
            pic.setUrl(picUrl);
            pic.setSource("gifdx.net");
            picService.save(pic);
        }
    }

    @Override
    public String getEachPageUrl(Integer pageNum){
        return getBaseUrl() + pageNum;
    }


}
