<#macro login path name>
    <form action="${path}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><label> Логин : <input type="text" name="username"/> </label></div>
        <div><label> Пароль: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="${name}"/></div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти из профиля"/>
    </form>
</#macro>

