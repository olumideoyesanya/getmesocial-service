package com.example.getmesocialservice.apiResource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.Comment;
import com.example.getmesocialservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment saveComment(@RequestBody Comment comment){
        return commentService.saveComment(comment);

    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/get-by-id")
    public List<Comment> getById(@RequestParam(name = "id") String id){
        return commentService.getById(id);
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){
         return commentService.updateComment(comment);
    }

    @DeleteMapping
    public void deleteComment(@RequestParam(name ="comment") Comment comment){
        commentService.deleteComment(comment);

    }
}
