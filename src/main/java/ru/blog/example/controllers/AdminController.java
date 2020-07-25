package ru.blog.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
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
@RequestMapping (path="/admin")
public class AdminController {
    private final ArticleRepo articleRepo;

    public AdminController (ArticleRepo articleRepo) {this.articleRepo = articleRepo;}

    @GetMapping
    public String index (Map< String, Object > model) {
        Iterable< Article > articles = articleRepo.findAll ();
        model.put ("articles", articles);
        return "admin";
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

        return "redirect:/admin";
    }

    @PostMapping(path = "/filter")
    public String find (@RequestParam String tag, Map< String, Object > model) {
        Iterable< Article > articles;
        if (tag != null && !tag.isEmpty ()) {
            articles = articleRepo.findByTag (tag);
        }else{
            articles = articleRepo.findAll ();
        }
        model.put ("articles", articles);
        return "admin";
    }

}
