package com.ormi.storywave.mypage;

import com.ormi.storywave.comment.Comment;
import com.ormi.storywave.comment.CommentService;
import com.ormi.storywave.posts.Post;
import com.ormi.storywave.posts.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

  private final CommentService commentService;
  private final PostService postService;

  @Autowired
  public MyPageController(CommentService commentService, PostService postService) {
    this.commentService = commentService;
    this.postService = postService;
  }

  // 현재 로그인된 사용자의 게시물을 페이지네이션하여 가져오는 엔드포인트
  @GetMapping("/mypost")
  public String getMyPosts(HttpSession session, Model model,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size) {
    // 세션에서 사용자 ID를 가져옴
    String userId = (String) session.getAttribute("userId");
    if (userId == null) {
      // 예외 처리: 로그인되지 않은 경우
      throw new IllegalStateException("로그인이 필요합니다.");
    }
    // 페이지네이션 설정
    Page<Post> postPage = postService.getPostsByUserId(userId, PageRequest.of(page - 1, size));
    model.addAttribute("posts", postPage.getContent());
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPages", postPage.getTotalPages());
    return "mypage/mypost";
  }

  // 현재 로그인된 사용자의 댓글을 페이지네이션하여 가져오는 엔드포인트
  @GetMapping("/mycomment")
  public String getMyComments(HttpSession session, Model model,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size) {
    // 세션에서 사용자 이름을 가져옴
    String username = (String) session.getAttribute("username");
    if (username == null) {
      // 예외 처리: 로그인되지 않은 경우
      throw new IllegalStateException("로그인이 필요합니다.");
    }
    // 페이지네이션 설정
    Page<Comment> commentPage = commentService.findCommentsByUsername(username, PageRequest.of(page - 1, size));
    model.addAttribute("comments", commentPage.getContent());
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPages", commentPage.getTotalPages());
    return "mypage/mycomment";
  }

  @GetMapping
  public String showMyPage(Model model) {
    return "mypage/mypage";
  }

  @GetMapping("/quit")
  public String showQuitPage(Model model) {
    return "mypage/quit";
  }

}
