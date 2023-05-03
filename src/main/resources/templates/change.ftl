<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Зміна БД</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="change-div">

        <label class="form-name">Виберіть базу даних</label>
        <a href="/ui/v1/mongo/login/">
            <button class="change-btn">MongoDB</button>
        </a>
        <a href="/ui/v1/mysql/login/">
            <button class="change-btn">MySQL</button>
        </a>
</div>
</body>
</html>