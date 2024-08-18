package com.ormi.storywave.comment;

import com.ormi.storywave.posts.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

  void deleteByUser_UserId(String userId);

  Page<Comment> findByUserUserId(String userId, Pageable pageable);

  List<Comment> findByPost_Id(Long id);

  Optional<Comment> findByPost_IdAndCommentId(Long postId, Long commentId);

  Integer countCommentsByPost_Id(Long postId);

  void deleteByPost(Post post);
}
