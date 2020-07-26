<#import "parts/general.ftlh" as g>
<@g.main>
    <h1>Добро пожаловать</h1>
    <a href="/create-article">Добавить статью</a>
    <a href="/login">Войти</a>
    <a href="/registration">Регистрация</a>
    <h2>Список статей</h2>
    <#list articles as article>
        <p>
            ID:${article.id} Title:${article.title}
            Date:${article.dateCreate} Context:${article.context}
            Author:${article.authorName} Tag:${article.tag}
        </p>
    <#else >
        <p>Нет записей</p>
    </#list>
</@g.main>