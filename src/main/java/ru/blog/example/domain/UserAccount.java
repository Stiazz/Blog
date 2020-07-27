package ru.blog.example.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class UserAccount implements UserDetails {


    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String email;

    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private String fileNameIcon;


    /* Spring Security Begin*/

    @Override
    public boolean isAccountNonExpired () {
        return true;
    }

    @Override
    public boolean isAccountNonLocked () {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired () {
        return true;
    }

    @Override
    public boolean isEnabled () {
        return isActive ();
    }

    @Override
    public Collection< ? extends GrantedAuthority > getAuthorities () {
        return getRoles ();
    }

    /* Spring Security End*/

    /* Get/Set Begin */

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getEmail () {
        if (email !=null && !email.isEmpty ())
        return email;
        else return "Не задан";
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public boolean isActive () {
        return active;
    }

    public void setActive (boolean active) {
        this.active = active;
    }

    public Set< Role > getRoles () {
        return roles;
    }

    public void setRoles (Set< Role > roles) {
        this.roles = roles;
    }

    public String getFileNameIcon () {
        return fileNameIcon;
    }

    public void setFileNameIcon (String fileNameIcon) {
        this.fileNameIcon = fileNameIcon;
    }

    /* Get/Set End */

}
