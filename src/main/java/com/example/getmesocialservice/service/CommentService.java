package com.example.getmesocialservice.service;

import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment comment){

        return commentRepository.save(comment);

    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Comment updateComment(Comment comment){
        return commentRepository.save(comment);

    }

    public void deleteComment(Comment comment){
         commentRepository.delete(comment);
    }
}
