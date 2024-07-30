package com.ormi.storywave.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer postId;
  private Integer userId;
  private String comment; // 댓글 내용
  private LocalDateTime createdAt; // 생성 시각
  private LocalDateTime updatedAt; // 수정 시각
  private String title; // 제목
  private String author; // 작성자
  private LocalDateTime date; // 추가된 필드: 날짜
}
