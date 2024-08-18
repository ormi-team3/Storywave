package com.ormi.storywave.mypage;

import com.ormi.storywave.comment.Comment;
import com.ormi.storywave.comment.CommentService;
import com.ormi.storywave.posts.Post;
import com.ormi.storywave.posts.PostService;
import com.ormi.storywave.users.UserDto;
import com.ormi.storywave.users.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

  private final CommentService commentService;
  private final PostService postService;
  private final UserService userService;

  @Autowired
  public MyPageController(
      CommentService commentService, PostService postsService, UserService userService) {
    this.commentService = commentService;
    this.postService = postsService;
    this.userService = userService;
  }

  // 마이페이지 컨트롤러 안에 내 댓글, 내 게시물 기능 넣을지? 아님 각 컨트롤러에 넣을지?

  @GetMapping
  public String showMyPage(HttpSession httpSession, Model model) {

    String findUserId = (String) httpSession.getAttribute("userId");

    UserDto userDto = userService.getUserById(findUserId).orElse(null);

    // 사용자 정보가 없으면 로그인 페이지로
    if (userDto == null) {
      return "redirect:/login";
    }

    String role = userService.getUserRole(userDto.getUserId());
    System.out.println(role);
    if ("ADMIN".equals(role)) {
      return "mypage/adminMypage";
    } else if ("USER".equals(role)) {
      return "mypage/mypage";
    } else {
      return "redirect:/error";
    }
  }

  @GetMapping("/quit")
  public String showQuitPage(Model model) {
    return "mypage/quit";
  }

  // 현재 로그인된 사용자의 게시물을 페이지네이션하여 가져오는 엔드포인트
  @GetMapping("/mypost")
  public String getMyPosts(
      HttpSession session,
      Model model,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "size", defaultValue = "10") int size) {
    // 세션에서 사용자 ID를 가져옴
    String userId = (String) session.getAttribute("userId");
    if (userId == null) {
      // 예외 처리: 로그인되지 않은 경우 로그인 페이지로 리디렉션
      throw new IllegalStateException("로그인이 필요합니다.");
      //      return "redirect:/login";
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
  public String getMyComments(
      HttpSession session,
      Model model,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "size", defaultValue = "10") int size) {
    // 세션에서 사용자 이름을 가져옴
    String userId = (String) session.getAttribute("userId");
    if (userId == null) {
      // 예외 처리: 로그인되지 않은 경우 로그인 페이지로 리디렉션
      throw new IllegalStateException("로그인이 필요합니다.");
      //      return "redirect:/login";
    }
    // 페이지네이션 설정
    Page<Comment> commentPage =
        commentService.findCommentsByUserId(userId, PageRequest.of(page - 1, size));
    model.addAttribute("comments", commentPage.getContent());
    model.addAttribute("currentPage", page);
    model.addAttribute("totalPages", commentPage.getTotalPages());
    return "mypage/mycomment";
  }

  @GetMapping("/update-user")
  public String updateUserForm(Model model, HttpSession session) {
    String findUserId = (String) session.getAttribute("userId");

    UserDto userDto = userService.getUserById(findUserId).orElse(null);

    model.addAttribute("user", userDto);

    return "mypage/update_user";
  }

  @PostMapping("/update-user")
  public String updateUser(@ModelAttribute("user") UserDto userDto, Model model) {
    UserDto updateduser = userService.updateUser(userDto.getUserId(), userDto).orElse(null);
    model.addAttribute("user", updateduser);

    return "mypage/update_user";
  }
}
