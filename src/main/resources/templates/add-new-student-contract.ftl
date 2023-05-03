<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Створення</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="button-contracts">
    <a href="/ui/v1/${dbname}/contracts/new">
        <button class="new-contract current-contract">Новий</button>
    </a>
    <a href="/ui/v1/${dbname}/contracts">
        <button class="old-contract">Існуючий</button>
    </a>
</div>
<div class="main-form">
    <form name="student-form" class="form-add" action="" method="POST">
        <label class="form-name">Додати студента</label>
        <label class="form-lbl">Прізвище</label>
        <@spring.formInput "student-form.lastName" "required class='form-input-text' placeholder='Фуштей'" "text"/><br>
        <label class="form-lbl">Ім'я</label>
        <@spring.formInput "student-form.firstName" "required class='form-input-text' placeholder='Максим'" "text"/><br>
        <label class="form-lbl">По батькові</label>
        <@spring.formInput "student-form.patronymic" "required class='form-input-text' placeholder='Танасійович'" "text"/><br>
        <label class="form-lbl">Вік</label>
        <@spring.formInput "student-form.age" "required class='form-input-text' min='10' max='100' placeholder='19'" "number"/><br>
        <label class="form-lbl">Номер телефону</label>
        <@spring.formInput "student-form.phone" "required class='form-input-text' pattern='+380[0-9]{9}' placeholder='+380964573514'"
        "tel"/><br>
        <label class="form-lbl">Email</label>
        <@spring.formInput "student-form.email" "required class='form-input-text' placeholder='maxym2003f@gmail.com'" "email"/><br>
        <label class="form-lbl">Опис</label>
        <@spring.formInput "student-form.description" "required class='form-input-text' placeholder='Деякий опис про студента'" "text"/><br>
        <label class="form-lbl">Виберіть мову і рівень</label>
        <@spring.formSingleSelect "student-form.group", groups, "class='form-input-select' required"/><br>
        <div class="check-payment">
            <input id="post" type="checkbox" name="postponeCheck">
            <label for="post" class="check-label">Відтермінування</label><br>
            <input id="check-priv" type="checkbox" name="privilegeCheck">
            <label for="check-priv" class="check-label">Пільги</label>
        </div>
        <br>
        <br>
        <input class="sbm-btn" type="submit" value="Створити" >
    </form>
</div>
</body>
</html>