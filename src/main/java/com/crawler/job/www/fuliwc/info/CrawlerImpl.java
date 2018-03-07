package com.crawler.job.www.fuliwc.info;

import com.crawler.job.CommonCrawler;
import com.crawler.model.Pic;
import com.crawler.service.PicService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        //body > section > div > div > article:nth-child(11) > p.focus > a > img
        Elements listImg = document.select("body > section > div > div p.focus > a > img");
        Elements listComments = document.select("body > section > div > div header > h2 > a");
        for(int i = 0; i < listImg.size(); i++){
            String picUrl = listImg.get(i).attributes().get("data-original");
            String picRemarks = listComments.get(i).html();
            Pic pic = new Pic();
            pic.setRemarks(picRemarks);
            pic.setUrl(picUrl);
            pic.setCategory(3);
            pic.setSource("www.fuliwc.info");
            picService.save(pic);
        }
    }

    @Override
    public String getEachPageUrl(Integer pageNum){
        return getBaseUrl() + pageNum;
    }

}
