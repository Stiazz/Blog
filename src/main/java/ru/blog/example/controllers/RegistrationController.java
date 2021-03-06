package ru.blog.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

import ru.blog.example.domain.Role;
import ru.blog.example.domain.UserAccount;
import ru.blog.example.repos.UserAccountRepo;

@Controller
@RequestMapping (path="/registration")
public class RegistrationController {
    private final UserAccountRepo userAccountRepo;

    public RegistrationController (UserAccountRepo userAccountRepo) {this.userAccountRepo = userAccountRepo;}

    @GetMapping
    public String index () {
        return "registration";
    }

    @PostMapping
    public String registration (UserAccount user, Model model) {
        UserAccount userFromDB = userAccountRepo.findByUsername (user.getUsername ());

        if (userFromDB != null){
            model.addAttribute ("message", "Такой пользователь уже существует");
            return "registration";
        }

        user.setActive (true);
        user.setRoles (Collections.singleton (Role.USER));
        userAccountRepo.save (user);

        return "redirect:/login";
    }

}
