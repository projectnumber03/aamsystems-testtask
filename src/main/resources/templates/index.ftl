<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/css/table.css">
    <link rel="stylesheet" href="/static/css/button.css">
    <title>Products</title>
</head>
<body>
<form method="post">
    <input type="text" name="search" placeholder="Введите название продукта...">
    <button class="button" name="searchButton">Найти</button>
    <table class="blueTable" style="width: 50%">
        <thead>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Описание</th>
                <th style="width: 10%"></th>
                <th style="width: 10%"></th>
            </tr>
        </thead>
        <tbody>
            <#list products as product>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td style="text-align: center"><button class="button" name="editButton" value="${product.id}">Редактировать</button></td>
                <td style="text-align: center"><button class="button" name="deleteButton" value="${product.id}">Удалить</button></td>
            </tr>
            </#list>
        </tbody>
    </table>
    <button class="button" name="addButton">Добавить</button>
</form>
</body>
</html>