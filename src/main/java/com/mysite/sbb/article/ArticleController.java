package com.mysite.sbb.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;


}
