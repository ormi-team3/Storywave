package com.ormi.storywave.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title; // 제목
  private String author; // 글쓴이

  @Temporal(TemporalType.DATE)
  private Date date; // 날짜

  private Integer likes; // 공감 수
  private LocalDateTime createdAt; // 생성 시각
  private LocalDateTime updatedAt; // 수정 시각

  private Integer comments; // 댓글 수를 나타냄

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
