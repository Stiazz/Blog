package ru.blog.example.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.blog.example.domain.Role;
import ru.blog.example.domain.UserAccount;
import ru.blog.example.repos.UserAccountRepo;

@Controller
@RequestMapping(path = "/profile")
public class UserProfileController {
    private UserAccountRepo userAccountRepo;

    public UserProfileController (UserAccountRepo userAccountRepo) {
        this.userAccountRepo = userAccountRepo;
    }

    @GetMapping
    public String getProfile(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserAccount user = (UserAccount)principal;
            model.addAttribute ("user", user);
        }
        return "profile";
    }
    @GetMapping("{user}")
    public String userEditForm(@PathVariable UserAccount user, Model model){
        model.addAttribute ("user", user);
        model.addAttribute ("roles", Role.values ());
        return "user-edit";
    }
}
