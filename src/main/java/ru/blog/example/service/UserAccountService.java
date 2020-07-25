package ru.blog.example.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.blog.example.repos.UserAccountRepo;

@Service
public class UserAccountService implements UserDetailsService {

    private final UserAccountRepo userAccountRepo;

    public UserAccountService (UserAccountRepo userAccountRepo) {
        this.userAccountRepo = userAccountRepo;
    }

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
        return userAccountRepo.findByUsername (username);
    }
}
