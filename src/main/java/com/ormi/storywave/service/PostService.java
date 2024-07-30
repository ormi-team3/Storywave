package com.ormi.storywave.service;

import com.ormi.storywave.model.Post;
import com.ormi.storywave.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

  private final PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Page<Post> findPaginated(int page, int pageSize) {
    Pageable pageable = PageRequest.of(page - 1, pageSize);
    return postRepository.findAll(pageable);
  }

  public Post createPost(Post post) {
    return postRepository.save(post);
  }

}
