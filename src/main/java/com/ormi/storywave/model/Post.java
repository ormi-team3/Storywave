package com.ormi.storywave.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer postTypeId;
  private String title;
  private String content;
  private Integer userId;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Integer thumbs;
  private Integer comments; // 댓글 수 필드 추가

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
