package com.ormi.storywave.controller;

import com.ormi.storywave.model.Comment;
import com.ormi.storywave.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommentController {

  @Autowired private CommentService commentService;

  @GetMapping("/myPage_myComment")
  public String getAllComments(
      Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
    int pageSize = 10;
    Page<Comment> commentPage = commentService.findPaginated(page, pageSize);
    model.addAttribute("comments", commentPage.getContent());
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPages", commentPage.getTotalPages());
    return "myPage_myComment";
  }

  @PostMapping("/comments")
  @ResponseBody
  public Comment createComment(@RequestBody Comment comment) {
    return commentService.createComment(comment);
  }
}
//  private final CommentService commentService;
//
//  @Autowired
//  public CommentController(CommentService commentService) {
//    this.commentService = commentService;
//  }
//
//  @GetMapping("/myPage_myComment")
//  public ModelAndView showComments() {
//    List<Comment> comments = commentService.getAllComments();
//    ModelAndView mav = new ModelAndView("myPage_myComment");
//    mav.addObject("posts", comments);
//    return mav;
//  }
//
//
//  @GetMapping
//  public List<Comment> getAllComments() {
//    return commentService.getAllComments();
//  }
//
//  @PostMapping
//  public Comment createComment(@RequestBody Comment comment) {
//    return commentService.createComment(comment);
//  }
// }
