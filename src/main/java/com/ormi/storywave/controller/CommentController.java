package com.ormi.storywave.controller;

import com.ormi.storywave.model.Comment;
import com.ormi.storywave.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

  @Autowired private CommentService commentService;

  @GetMapping("/comments")
  public String showComments(Model model) {
    List<Comment> comments = commentService.getAllComments();
    model.addAttribute("comments", comments);
    return "myPage_myComment";
  }

  @GetMapping
  public List<Comment> getAllComments() {
    return commentService.getAllComments();
  }

  @PostMapping
  public Comment createComment(@RequestBody Comment comment) {
    return commentService.createComment(comment);
  }
}
