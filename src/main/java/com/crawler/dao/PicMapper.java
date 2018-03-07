package com.crawler.dao;

import com.crawler.model.Pic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2018/3/6.
 */
public interface PicMapper {

    void save(Pic pic);

    List<Pic> getPicList(@Param("start") Integer start,@Param("offset") Integer offset,@Param("category") Integer category);
}
