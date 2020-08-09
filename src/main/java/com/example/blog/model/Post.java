package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    private Category category;
    @CreationTimestamp
    private LocalDateTime dateAdded;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User author;
}
