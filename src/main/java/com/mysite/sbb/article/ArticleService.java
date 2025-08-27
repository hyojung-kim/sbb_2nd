package com.mysite.sbb.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }
}
