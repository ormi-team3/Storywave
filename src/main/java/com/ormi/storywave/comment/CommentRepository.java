package com.ormi.storywave.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

  Page<Comment> findByUserUsername(String username, Pageable pageable);

  List<Comment> findByPost_Id(Long id);

  Optional<Comment> findByPost_IdAndCommentId(Long postId, Long commentId);

  Integer countCommentsByPost_Id(Long postId);
}

