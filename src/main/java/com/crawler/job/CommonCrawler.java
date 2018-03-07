package com.crawler.job;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/3/6.
 */
public class CommonCrawler implements Crawler{

    Logger logger = Logger.getLogger(CommonCrawler.class);

    private Integer pageCount;

    private String baseUrl;

    @Autowired
    TaskExecutor taskExecutor;

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getEachPageUrl(Integer pageNum) {
        return null;
    }

    @Override
    public void doCrawlOnePage(String url) throws Exception{
        return;
    }

    //多线程并发去爬取不同page
    @Override
    public void doCrawl(Integer threads){
        List<String> urls = new ArrayList<>();
        for(int i = 0; i <= getPageCount(); i++){
            urls.add(i, getEachPageUrl(i));
        }
        Integer count = urls.size() / threads;
        for (int i = 0; i < threads; i++) {
            final List<String> temp = urls.subList(i * count, (i + 1) * count);
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    for(String s : temp){
                        try {
                            doCrawlOnePage(s);
                        }catch (Exception e){
                            logger.error(e.getMessage());
                        }
                    }
                }
            });
            if (urls.size() % threads != 0) {
                final List<String> remain = urls.subList(threads * count, urls.size());
                taskExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        for(String s : remain){
                            try {
                                doCrawlOnePage(s);
                            }catch (Exception e){
                                logger.error(e.getMessage());
                            }
                        }
                    }
                });
            }
        }
    }
}
