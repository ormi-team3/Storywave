package com.ormi.storywave.controller;

import com.ormi.storywave.model.Comment;
import com.ormi.storywave.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

  private final CommentService commentService;

  @Autowired
  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping("/myPage_myComment")
  public ModelAndView showComments() {
    List<Comment> comments = commentService.getAllComments();
    ModelAndView mav = new ModelAndView("myPage_myComment");
    mav.addObject("posts", comments);
    return mav;
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
