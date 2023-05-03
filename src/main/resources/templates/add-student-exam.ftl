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
    <form name="exam-form" class="form-add" action="" method="POST">
        <label class="form-name">Створення екзамену для учня</label>
        <label class="form-lbl">Назва</label>
        <@spring.formInput "exam-form.name" "class='form-input-text' required" "text"/><br>
        <label class="form-lbl">Опис</label>
        <@spring.formInput "exam-form.description" "class='form-input-text' required" "text"/><br>
        <label class="form-lbl">Студент</label>
        <@spring.formSingleSelect "exam-form.student", students, "class='form-input-select' required"/><br>
        <label class="form-lbl">Екзамен</label>
        <@spring.formSingleSelect "exam-form.exam", exams, "class='form-input-select' required"/><br>
        <label class="form-lbl">Оцінка</label>
        <@spring.formInput "exam-form.mark" "min='0' max='100' class='form-input-text' required" "number"/><br>
        <input class="sbm-btn" type="submit" value="Створити">
    </form>
</div>
</body>
</html>