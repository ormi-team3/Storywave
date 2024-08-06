package com.ormi.storywave.comment;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class CommentAPIController {
  private final CommentService commentService;

  @Autowired
  public CommentAPIController(CommentService commentService) {
    this.commentService = commentService;
  }

  @PostMapping("/{postId}/comments")
//  public ResponseEntity<CommentDto> createComment(
//          @RequestBody CommentDto commentDto,
//          @PathVariable("postId") Long postId,
//          @RequestParam("userId") String userId) {
  public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable("postId") Long postId, HttpSession session){
    String userId = (String) session.getAttribute("userId");
    CommentDto createdComment = commentService.createComment(commentDto, postId, userId);
    return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
  }

  @GetMapping("/{postId}/comments")
  public ResponseEntity<List<CommentDto>> getAllComment(@PathVariable("postId") Long postId) {
    List<CommentDto> commentDtos = commentService.getAllComments(postId);
    return ResponseEntity.ok(commentDtos);
  }

  @GetMapping("/{postId}/comments/{commentId}")
  public CommentDto getCommentById(
          @PathVariable("postId") Long postId, @PathVariable("commentId") Long commentId) {
    return commentService.getCommentById(commentId);
  }

  @PutMapping("/{postId}/comments/{commentId}")
//  public ResponseEntity<CommentDto> updateComment(
//          @PathVariable("postId") Long postId,
//          @PathVariable("commentId") Long commentId,
//          @RequestBody CommentDto commentDto,
//          @RequestParam("userId") String userId) {
  public ResponseEntity<CommentDto> updateComment(
          @PathVariable("postId") Long postId,
          @PathVariable("commentId") Long commentId,
          @RequestBody CommentDto commentDto,
          HttpSession session) {
    String userId = (String) session.getAttribute("userId");
    return commentService
            .updateComment(postId, commentId, commentDto, userId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{postId}/comments/{commentId}")
//  public ResponseEntity<Integer> deleteComment(
//          @PathVariable("postId") Long postId,
//          @PathVariable("commentId") Long commentId,
//          @RequestParam("userId") String userId) {
  public ResponseEntity<Integer> deleteComment(
          @PathVariable("postId") Long postId,
          @PathVariable("commentId") Long commentId,
          HttpSession session) {
    String userId = (String) session.getAttribute("userId");
    commentService.deleteComment(postId, commentId, userId);
    return ResponseEntity.noContent().build();
  }
}
