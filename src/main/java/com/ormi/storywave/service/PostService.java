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

  // PostRepository 주입받고 초기화하는 생성자
  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  // 모든 게시물 반환하는 메서드
  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  // 페이지 번호, 크기를 기반으로 페이지네이션된 게시물 반환 메서드
  public Page<Post> findPaginated(int page, int pageSize) {
    Pageable pageable = PageRequest.of(page - 1, pageSize);
    return postRepository.findAll(pageable);
  }

  // 새로운 게시물 생성, 저장 메서드
  public Post createPost(Post post) {
    return postRepository.save(post);
  }
}
