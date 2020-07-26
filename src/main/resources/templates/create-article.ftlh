<#import "parts/general.ftlh" as g>
<#import "parts/login.ftlh" as l>
<@g.main>
    <@l.logout/>
    <span><a href="/user">Список пользователей</a></span>

    <form method="post" action="/create-article/add">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="text" name="title" placeholder="Введите заголовок">
        <input type="text" name="context" placeholder="Введите текст">
        <input type="text" name="tag" placeholder="Введите тэг">
        <button type="submit">Добавить</button>
    </form>

    <div>Список статей</div>
    <#list articles as article>
        <p>
            ID:${article.id} Title:${article.title}
            Date:${article.dateCreate} Context:${article.context}
            Author:${article.authorName} Tag:${article.tag}
        </p>
    <#else >
        <p>Нет записей</p>
    </#list>

    <form method="get" action="/create-article">
        <input type="text" name="tag" placeholder="Поиск по тэгу">
        <button type="submit">Поиск</button>
    </form>
</@g.main>