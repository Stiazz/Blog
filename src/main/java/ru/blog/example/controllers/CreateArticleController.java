package ru.blog.example.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.Map;

import ru.blog.example.domain.Article;
import ru.blog.example.domain.UserAccount;
import ru.blog.example.repos.ArticleRepo;

@Controller
@RequestMapping (path="/create-article")
public class CreateArticleController {
    private final ArticleRepo articleRepo;

    public CreateArticleController (ArticleRepo articleRepo) {this.articleRepo = articleRepo;}

    @GetMapping
    public String index (@RequestParam(required = false) String filter,  Model model) {
        Iterable< Article > articles = articleRepo.findAll ();

        if (filter != null && !filter.isEmpty ()) {
            articles = articleRepo.findByTag (filter);
        }else{
            articles = articleRepo.findAll ();
        }

        model.addAttribute ("articles", articles);
        model.addAttribute ("filter", filter);
        return "/create-article";
    }

    @PostMapping(path = "/add")
    public String add(
            @RequestParam String title,
            @AuthenticationPrincipal UserAccount author,
            @RequestParam String context,
            @RequestParam String tag ,
            Map< String, Object > model)
    {
        /* Правильно ли? */
        Article article = new Article (title, new Date (), context, author, tag);
        articleRepo.save (article);

        return "redirect:/create-article";
    }
}
