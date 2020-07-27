package ru.blog.example.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Article {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private Date dateCreate;

    private String context;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "user_id")
    private UserAccount author;

    private String tag;

    public Article () {

    }

    public Article (String title, Date dateCreate, String context, UserAccount user, String tag) {
        this.title = title;
        this.dateCreate = dateCreate;
        this.context = context;
        this.author = user;
        this.tag = tag;
    }

    /* Get/Set Begin */

    public String getAuthorName () {
        return author != null ? author.getUsername () : "<none>";
    }

    /* Нужно додумать */
    public String getDateCreate () {
        String pattern = "dd-MM-yyyy HH:mm";
        Locale locale = new Locale ("ru", "RU");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat (pattern, locale);
        return simpleDateFormat.format (dateCreate);
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public void setDateCreate (Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public UserAccount getAuthor () {
        return author;
    }

    public void setAuthor (UserAccount author) {
        this.author = author;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getContext () {
        return context;
    }

    public void setContext (String context) {
        this.context = context;
    }

    public String getTag () {
        return tag;
    }

    public void setTag (String tag) {
        this.tag = tag;
    }

    /* Get/Set End */
}
