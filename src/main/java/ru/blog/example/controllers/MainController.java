package ru.blog.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.blog.example.domain.Article;
import ru.blog.example.repos.ArticleRepo;

@Controller
@RequestMapping (path="/")
public class MainController {
    private final ArticleRepo articleRepo;

    public MainController (ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    @GetMapping
    public String index (Model model) {
        Iterable< Article > articles = articleRepo.findAll ();
        model.addAttribute ("articles", articles);
        return "index";
    }
}
