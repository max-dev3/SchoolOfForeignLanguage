<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Вхід</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="main-form">
    <form name="user-form" class="form-add" action="" method="POST">
        <label class="form-name">Вхід</label>
        <label class="form-lbl">Email</label>
        <@spring.formInput "user-form.email" "required class='form-input-text' placeholder='maxym2003f@gmail.com'" "email"/><br>
        <label class="form-lbl">Пароль</label>
        <@spring.formInput "user-form.password" "required class='form-input-text'" "password"/><br>
        <label class="error">${error}</label>
        <br>
        <input class="sbm-btn-login" type="submit" value="Увійти">
        <label class="account-exist">Немає акаунту? <a class="registration" href="/ui/v1/${dbname}/registration/"><b>Зареєструватися</b></a></label>
        <a class="forgot" href="/ui/v1/${dbname}/forgot/">Забули пароль?</a>
    </form>
</div>
</body>
</html>