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
    <input type="hidden" id="id" name="id" value="${product.id!}">
    <label for="description">Описание продукта</label><br>
    <textarea id="description" name="description">${product.description!}</textarea><br>
    <button class="button">Сохранить</button>
</form>
</body>
</html>