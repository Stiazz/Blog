<#import "parts/general.ftlh" as g>
<@g.main>
    <h1>Профиль</h1>
    <p>Логин: ${user.username}</p>
    <p>Почта: ${user.email}</p>
    <p>Роль: <#list user.roles as role>${role}</#list></p>
    <p>Иконка:
        <#if user.fileNameIcon??>
            <img src="/img/${user.fileNameIcon}">
            <#else >Не задан
        </#if>
    </p>
</@g.main>