package com.mysite.sbb.comment;

import com.mysite.sbb.article.Article;
import com.mysite.sbb.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/comment")
@RequiredArgsConstructor
@Controller
public class CommentController {
    private final ArticleService articleService;
    private final CommentService commentService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
        Article article = this.articleService.getArticle(id);
        // TODO: 답변을 저장한다.
        this.commentService.create(article, content);

        return String.format("redirect:/article/detail/%s", id);
    }
}
