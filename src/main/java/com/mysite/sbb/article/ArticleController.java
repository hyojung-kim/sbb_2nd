package com.mysite.sbb.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> artileList = this.articleService.findAll();
        model.addAttribute("artileList", artileList);
        return "/article/article_list";
    }

}
