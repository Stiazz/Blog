<#import "parts/general.ftlh" as g>
<@g.main>
    <h1>Редактирование пользователя: </h1>
    <form action="/user" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="hidden" name="user-id" value="${user.id}">
        <input type="text" name="user-name" value="${user.username}">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}</label>
            </div>
        </#list>
        <button type="submit">Сохранить</button>
    </form>
</@g.main>