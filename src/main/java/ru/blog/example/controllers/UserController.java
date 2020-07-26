package ru.blog.example.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import ru.blog.example.domain.Role;
import ru.blog.example.domain.UserAccount;
import ru.blog.example.repos.UserAccountRepo;

@Controller
@RequestMapping(path = "/user")
@PreAuthorize ("hasAuthority('ADMIN')")
public class UserController {
    private final UserAccountRepo userAccountRepo;

    public UserController (UserAccountRepo userAccountRepo) {
        this.userAccountRepo = userAccountRepo;
    }

    @GetMapping
    public String userList(Model model){
        List< UserAccount > users = userAccountRepo.findAll ();
        model.addAttribute ("users", users);
        return "user-list";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable UserAccount user, Model model){
        model.addAttribute ("user", user);
        model.addAttribute ("roles", Role.values ());
        return "user-edit";
    }

    @PostMapping
    public String userSafe(
            @RequestParam String userName,
            @RequestParam Map<String,String> form,
            @RequestParam("user-id") UserAccount user)
    {
        user.setUsername (userName);

        userAccountRepo.save (user);

        Set< String > roles = Arrays.stream (Role.values ())
                .map (Role::name)
                .collect (Collectors.toSet ());

        user.getRoles ().clear ();

        for (String key : form.keySet ()){
            if (roles.contains (key)){
                user.getRoles ().add (Role.valueOf (key));
            }
        }

        return "redirect:/user-list";
    }
}
