<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Реєстрація</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="main-form">
    <form name="user-form" class="form-add" action="" method="POST">
        <label class="form-name">Реєстрація</label>
        <label class="form-lbl">Email</label>
        <@spring.formInput "user-form.email" "required class='form-input-text' placeholder='maxym2003f@gmail.com'" "email"/><br>
        <label class="form-lbl">Пароль</label>
        <@spring.formInput "user-form.password" "required class='form-input-text' pattern='.{6,}' placeholder='Мінімально 6 символів'" "password"/><br>
        <label class="error">${error}</label>
        <br>
        <input class="sbm-btn-login" type="submit" value="Зареєструватися">
    </form>
</div>
</body>
</html>