<#import "parts/general.ftlh" as g>
<#import "parts/login.ftlh" as l>

<@g.main>
    <h1>Регистрация</h1>
    ${message!}
    <@l.login "/registration" "Регистрация"/>
    </body>
</@g.main>