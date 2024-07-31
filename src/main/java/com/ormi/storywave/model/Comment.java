package com.ormi.storywave.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String comment; // 댓글 내용

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post; // Post 엔티티와의 관계

  private LocalDateTime createdAt; // 생성 시각
  private LocalDateTime updatedAt; // 수정 시각

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
