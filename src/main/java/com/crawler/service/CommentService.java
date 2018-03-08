package com.crawler.service;

import com.crawler.dao.CommentMapper;
import com.crawler.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/3/8.
 */
@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    public void save(Integer gid, String comment, String user){
        Comment c = new Comment();
        c.setComment(comment);
        c.setUser(user);
        c.setGid(gid);
        commentMapper.save(c);
    }

    public List<Comment> getComments(Integer gid){
       return commentMapper.getCommentList(gid);
    }
}
