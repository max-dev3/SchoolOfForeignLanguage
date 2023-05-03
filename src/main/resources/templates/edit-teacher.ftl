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
<div class="main-form" >
    <form name="teacher" class="form-add" action="" method="POST">
        <label class="form-name">Оновити викладача</label>
        <label class="form-lbl">Прізвище</label>
        <@spring.formInput "teacher-form.lastName" "required class='form-input-text' placeholder='Фуштей'" "text"/><br>
        <label class="form-lbl">Ім'я</label>
        <@spring.formInput "teacher-form.firstName" "required class='form-input-text' placeholder='Максим'" "text"/><br>
        <label class="form-lbl">По батькові</label>
        Patronymic: <@spring.formInput "teacher-form.patronymic" "required class='form-input-text' placeholder='Танасійович'" "text"/><br>
        <label class="form-lbl">Номер телефону</label>
        <@spring.formInput "teacher-form.phone" "required class='form-input-text' pattern='+380[0-9]{9}' placeholder='+380964573514'" "tel"/><br>
        <label class="form-lbl">Email</label>
        <@spring.formInput "teacher-form.email" "required class='form-input-text' placeholder='maxym2003f@gmail.com'" "email"/><br>
        <label class="form-lbl">Досвід роботи</label>
        <@spring.formInput "teacher-form.experience" "required class='form-input-text' min='0' max='50' placeholder='10'" "number"/><br>
        <label class="form-lbl">Опис</label>
        <@spring.formInput "teacher-form.description" "required class='form-input-text' placeholder='Деякий опис про викладача'" "text"/><br>
        <br>
        <input class="sbm-btn" type="submit" value="Оновити">

    </form>
</div>
</body>
</html>