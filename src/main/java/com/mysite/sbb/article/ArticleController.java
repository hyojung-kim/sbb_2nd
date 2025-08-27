package com.mysite.sbb.article;

import com.mysite.sbb.comment.CommentForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> artileList = this.articleService.findAll();
        model.addAttribute("articleList", artileList);
        return "/article/article_list";
    }
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, CommentForm commentForm) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        model.addAttribute("commentForm", new CommentForm());
        return "/article/article_detail";
    }
    @GetMapping("/create")
    public String questionCreate(ArticleForm articleForm) {
        return "/article/article_form";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid ArticleForm articleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/article/article_form";
        }
        // TODO 질문을 저장한다.
        this.articleService.create(articleForm.getSubject(), articleForm.getContent());
        return "redirect:/article/list"; // 질문 저장후 질문목록으로 이동
    }

}
