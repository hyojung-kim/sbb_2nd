package com.mysite.sbb.article;

import com.mysite.sbb.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> findAll() {
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isPresent()) {
            return article.get();
        } else {
            throw new DataNotFoundException("article not found");
        }
    }
    public void create(String subject, String content) {
        Article article = new Article();
        article.setContent(content);
        article.setSubject(subject);
        article.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(article);
    }

    public Page<Article> getList(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return this.articleRepository.findAll(pageable);
    }
}
