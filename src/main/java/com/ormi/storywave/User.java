//package com.ormi.storywave;
//
//import com.ormi.storywave.model.Post;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.OneToMany;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.data.annotation.Id;
//
//import javax.xml.stream.events.Comment;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String username;
//    private String password;
//    private String nickname;
//    private String email;
//    private String role;
//    private String activeStatus;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//
//    // 관계 설정
//    @OneToMany(mappedBy = "user")
//    private List<Post> posts;
//
//    @OneToMany(mappedBy = "user")
//    private List<Comment> comments;
//}
