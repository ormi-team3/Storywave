package com.ormi.storywave.service;

import com.ormi.storywave.model.Comment;
import com.ormi.storywave.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

  private final CommentRepository commentRepository;

  @Autowired
  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public List<Comment> getAllComments() {
    return commentRepository.findAll();
  }

  public Page<Comment> findPaginated(int page, int pageSize) {
    Pageable pageable = PageRequest.of(page - 1, pageSize);
    return commentRepository.findAll(pageable);
  }

  public Comment createComment(Comment comment) {
    return commentRepository.save(comment);
  }
}
