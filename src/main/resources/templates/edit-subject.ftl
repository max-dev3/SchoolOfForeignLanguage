<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Оновлення</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="main-form">
    <form name="subject-form" class="form-add" action="" method="POST">
        <label class="form-name">Оновлення предмету</label>
        <label class="form-lbl">Назва предмету</label>
        <@spring.formInput "subject-form.name" "required class='form-input-text' placeholder='Розмовна англійська'" "text"/><br>
        <label class="form-lbl">Опис предмету</label>
        <@spring.formInput "subject-form.description" "required class='form-input-text'
        placeholder='Вивчення англійської для покращення комунікаційних навичок'" "text"/><br>
        <input class="sbm-btn" type="submit" value="Оновити">

    </form>
</div>
</body>
</html>