package com.ormi.storywave.mypage;

import com.ormi.storywave.comment.Comment;
import com.ormi.storywave.comment.CommentService;
import com.ormi.storywave.posts.Post;
import com.ormi.storywave.posts.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
  public MyPageController(CommentService commentService, PostService postsService) {
    this.commentService = commentService;
    this.postService = postsService;
  }

  // 현재 로그인된 사용자의 댓글을 가져오는 엔드포인트
  @GetMapping("/mycomments")
  public String getMyComments(HttpSession session, Model model) {
    // 세션에서 사용자 아이디를 가져옴
    String username = (String) session.getAttribute("username");
    if (username == null) {
      // 예외 처리: 로그인되지 않은 경우
      throw new IllegalStateException("로그인이 필요합니다.");
    }
    // 서비스 레이어를 통해 댓글 목록을 가져옴
    List<Comment> comments = commentService.findCommentsByUsername(username);
    model.addAttribute("comments", comments);
    return "mypage/mycomment";
  }

  // 마이페이지 컨트롤러 안에 내 댓글, 내 게시물 기능 넣을지? 아님 각 컨트롤러에 넣을지?

  @GetMapping
  public String showMyPage(Model model) {
    return "mypage/mypage";
  }

  @GetMapping("/quit")
  public String showQuitPage(Model model) {
    return "mypage/quit";
  }

  @GetMapping("/mypost")
  public String getAllPosts(
      Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
    int pageSize = 10; // 한 페이지에 보여줄 게시글 수
    Page<Post> postPage = postService.findPaginated(page, pageSize);

    // 모델에 데이터를 추가하여 뷰에 전달
    model.addAttribute("posts", postPage.getContent()); // 현재 페이지 게시물 리스트
    model.addAttribute("currentPage", page); // 현재 페이지 번호
    model.addAttribute("totalPages", postPage.getTotalPages()); // 총 페이지 수
    return "mypage/mypost"; // mypage/mypost.html 템플릿을 반환
  }
}
