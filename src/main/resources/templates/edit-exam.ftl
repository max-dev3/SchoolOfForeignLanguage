<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Оновлення</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="main-form">
    <form name="exam-form" class="form-add" action="" method="POST">
        <label class="form-name">Оновлення екзамену для всіх</label>
        <label class="form-lbl">Назва екзамену</label>
        <@spring.formInput "exam-form.name" "required class='form-input-text'" "text"/><br>
        <label class="form-lbl">Опис</label>
        <@spring.formInput "exam-form.description" "required class='form-input-text'" "text"/><br>
        <label class="form-lbl">Група</label>
        <@spring.formSingleSelect "exam-form.group", groups, "required class='form-input-select'"/><br>
        <label class="form-lbl">Предмет</label>
        <@spring.formSingleSelect "exam-form.subject", subjects, "required class='form-input-select'"/><br>
        <input class="sbm-btn" type="submit" value="Оновити">

    </form>
</div>
</body>
</html>