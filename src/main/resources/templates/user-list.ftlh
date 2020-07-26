<#import "parts/general.ftlh" as g>
<@g.main>
    <h1>Список пользователей: </h1>
    <table>
        <thead>
        <tr>
            <th>Имя</th>
            <th>Роль</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role} <#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        </tbody>
        </#list>
    </table>



</@g.main>