<#import "parts/general.ftlh" as g>
<#import "parts/login.ftlh" as l>

<@g.main>
    <h1>Авторизация</h1>
    <@l.login "/login" "Войти"/>
    <a href="/registration">Ргеистрация</a>
    </body>
</@g.main>