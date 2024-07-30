package com.ormi.storywave.controller;

import com.ormi.storywave.model.Post;
import com.ormi.storywave.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

  @Autowired private PostService postService;

  @GetMapping("/myPage_myPost")
  public String getAllPosts(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
    int pageSize = 10; // 한 페이지에 보여줄 게시글 수
    Page<Post> postPage = postService.findPaginated(page, pageSize);

    model.addAttribute("posts", postPage.getContent());
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPages", postPage.getTotalPages());
    return "myPage_myPost";
  }

  @PostMapping("/posts")
  @ResponseBody
  public Post createPost(@RequestBody Post post) {
    return postService.createPost(post);
  }
}
