package com.ormi.storywave.controller;

import com.ormi.storywave.model.Post;
import com.ormi.storywave.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

  @Autowired private PostService postService;

  @GetMapping("/myPage_myPost")
  public String getAllPosts(Model model) {
    List<Post> posts = postService.getAllPosts();
    model.addAttribute("posts", posts);
    return "myPage_myPost";
  }

  @PostMapping("/posts")
  @ResponseBody
  public Post createPost(@RequestBody Post post) {
    return postService.createPost(post);
  }
}
