package com.mysite.sbb.article;

import com.mysite.sbb.comment.CommentForm;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        //List<Article> artileList = this.articleService.findAll();
        //model.addAttribute("articleList", artileList);
        Page<Article> paging = this.articleService.getList(page);
        model.addAttribute("paging", paging);
        return "/article/article_list";
    }
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, CommentForm commentForm) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        model.addAttribute("commentForm", new CommentForm());
        return "/article/article_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String questionCreate(ArticleForm articleForm) {
        return "/article/article_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String questionCreate(@Valid ArticleForm articleForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "/article/article_form";
        }
        // TODO 질문을 저장한다.
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.articleService.create(articleForm.getSubject(), articleForm.getContent(), siteUser);
        return "redirect:/article/list"; // 질문 저장후 질문목록으로 이동
    }

}
