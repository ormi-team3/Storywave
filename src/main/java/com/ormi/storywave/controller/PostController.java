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

  // PostService 자동 주입
  @Autowired private PostService postService;

  // myPage_myPost 경로로 GET 요청 처리
  @GetMapping("/myPage_myPost")
  public String getAllPosts(
      Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
    int pageSize = 10; // 한 페이지에 보여줄 게시글 수
    Page<Post> postPage = postService.findPaginated(page, pageSize);

    // 모델에 데이터를 추가하여 뷰에 전달
    model.addAttribute("posts", postPage.getContent()); // 현재 페이지 게시물 리스트
    model.addAttribute("currentPage", page); // 현재 페이지 번호
    model.addAttribute("totalPages", postPage.getTotalPages()); // 총 페이지 수
    return "myPage_myPost"; // myPage_myPost.html 템플릿을 반환
  }

  // /posts 경로로 POST 요청을 처리하여 새로운 게시물 생성
  @PostMapping("/posts")
  @ResponseBody
  public Post createPost(@RequestBody Post post) {
    return postService.createPost(post); // 새로운 게시물 생성 후 반환
  }
}
