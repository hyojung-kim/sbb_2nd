package com.mysite.sbb.comment;

import com.mysite.sbb.article.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    //@CreatedDate   // 생성 시 자동 세팅
    //@Column(nullable = false, updatable = false)
    private LocalDateTime createDate;

    @ManyToOne
    private Article article;
}
