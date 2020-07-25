package ru.blog.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.blog.example.domain.UserAccount;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserAccountRepo extends JpaRepository< UserAccount, Integer> {
    UserAccount findByUsername(String username);
}
