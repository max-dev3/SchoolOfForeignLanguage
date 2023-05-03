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
  <form name="student" class="form-add" action="" method="POST">
    <label class="form-name">Оновити студента</label>
    <label class="form-lbl">Прізвище</label>
    <@spring.formInput "form.lastName" "required class='form-input-text' placeholder='Фуштей'" "text"/><br>
    <label class="form-lbl">Ім'я</label>
    <@spring.formInput "form.firstName" "required class='form-input-text' placeholder='Максим'" "text"/><br>
    <label class="form-lbl">По батькові</label>
    <@spring.formInput "form.patronymic" "required class='form-input-text' placeholder='Танасійович'" "text"/><br>
    <label class="form-lbl">Вік</label>
    <@spring.formInput "form.age" "required class='form-input-text' min='10' max='100' placeholder='19'" "number"/><br>
    <label class="form-lbl">Номер телефону</label>
    <@spring.formInput "form.phone" "required class='form-input-text' pattern='[+]380[0-9]{9}' placeholder='+380964573514'"
    "tel"/><br>
    <label class="form-lbl">Email</label>
    <@spring.formInput "form.email" "required class='form-input-text' placeholder='maxym2003f@gmail.com'" "email"/><br>
    <label class="form-lbl">Опис</label>
    <@spring.formInput "form.description" "required class='form-input-text' placeholder='Деякий опис про студента'" "text"/><br>
    <br>
    <input class="sbm-btn" type="submit" value="Оновити">

  </form>
</div>
</body>
</html>