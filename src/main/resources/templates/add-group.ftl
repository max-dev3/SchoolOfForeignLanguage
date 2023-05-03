<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Створення</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="main-form">
    <form name="group-form" class="form-add" action="" method="POST">
        <label class="form-name">Сворення групи</label>
        <label class="form-lbl">Назва групи</label>
        <@spring.formInput "group-form.name" "required class='form-input-text' placeholder='133А'" "text"/><br>
        <label class="form-lbl">Опис групи</label>
        <@spring.formInput "group-form.description" "required class='form-input-text'
         placeholder='Вивчення англійської мови для початківців'" "text"/><br>
        <label class="form-lbl">Вибір мови</label>
        <@spring.formSingleSelect "group-form.language", languages, "required class='form-input-select'"/><br>
        <label class="form-lbl">Вибір рівня</label>
        <@spring.formSingleSelect "group-form.level", levels, "required class='form-input-select'"/><br>
        <label class="form-lbl">Дата початку</label>
        <@spring.formInput "group-form.startDate" "required class='form-input-text'" "date"/><br>
        <label class="form-lbl">Викладач</label>
        <@spring.formSingleSelect "group-form.teacher", teachers, "required class='form-input-select'"/><br>
        <input class="sbm-btn" type="submit" value="Створити">

    </form>
</div>
</body>
</html>