package ru.blog.example.repos;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import ru.blog.example.domain.Article;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ArticleRepo extends CrudRepository< Article, Integer> {
    List<Article> findByTag(String tag);
}
