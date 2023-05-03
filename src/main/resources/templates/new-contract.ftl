<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Створення</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="main-form">
    <form name="contract-form" class="form-add" action="" method="POST">
        <label class="form-name">Вибір додаткової мови</label>
        <label class="form-lbl">Назва</label>
        <@spring.formInput "contract-form.name" "class='form-input-text' required" "text"/><br>
        <label class="form-lbl">Опис</label>
        <@spring.formInput "contract-form.description" "class='form-input-text' required" "text"/><br>
        <label class="show-lbl">Студент:</label>
        <label class="show-lbl">${student}</label><br>
        <label class="form-lbl">Група</label>
        <@spring.formSingleSelect "contract-form.group", groups1, "class='form-input-select' required"/><br>
        <input class="sbm-btn" type="submit" value="Створити" >

    </form>
</div>
</body>
</html>