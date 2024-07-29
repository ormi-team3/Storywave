package com.ormi.storywave.repository;


import com.ormi.storywave.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
