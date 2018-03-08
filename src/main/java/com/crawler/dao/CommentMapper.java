package com.crawler.dao;

import com.crawler.model.Comment;
import com.crawler.model.Pic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2018/3/6.
 */
public interface CommentMapper {

    void save(Comment comment);

    List<Comment> getCommentList(@Param("gid") Integer gid);
}
