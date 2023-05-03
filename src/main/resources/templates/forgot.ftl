<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Забув</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="main-form">
    <form name="user-form" class="form-add" action="" method="POST">
        <label class="form-name">Забули пароль</label>
        <label class="form-lbl">Email</label>
        <@spring.formInput "user-form.email" "required class='form-input-text' placeholder='maxym2003f@gmail.com'" "email"/><br>
        <label class="password">${password}</label>
        <label class="error">${error}</label>
        <br>
        <input class="sbm-btn-login" type="submit" value="Відобразити">
        <a class="forgot" href="/ui/v1/${dbname}/login/">Увійти</a>
        <a class="forgot" href="/ui/v1/${dbname}/registration/">Зареєструватися</a>
    </form>
</div>
</body>
</html>