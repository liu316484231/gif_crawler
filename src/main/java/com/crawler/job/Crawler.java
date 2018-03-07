package com.crawler.job;

import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/3/6.
 */
public interface Crawler {

    void doCrawlOnePage(String url) throws Exception;

    void doCrawl(Integer threads);

    String getEachPageUrl(Integer pageNum);
}
