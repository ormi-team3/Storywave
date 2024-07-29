package com.ormi.storywave.repository;

import com.ormi.storywave.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Integer> {}
