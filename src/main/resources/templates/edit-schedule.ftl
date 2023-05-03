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
    <form name="schedule-form" class="form-add" action="" method="POST">
        <label class="form-name">Оновлення розкладу</label>
        <label class="form-lbl">День тижня</label>
        <@spring.formSingleSelect "schedule-form.day", days, "required class='form-input-select'"/><br>
        <label class="form-lbl">Група</label>
        <@spring.formSingleSelect "schedule-form.group", groups, "required class='form-input-select'"/><br>
        <label class="form-lbl">Номер кімнати</label>
        <@spring.formInput "schedule-form.classroom" "required class='form-input-text' placeholder='109'" "number"/><br>
        <label class="form-lbl">Час початку заняття</label>
        <@spring.formInput "schedule-form.startLesson" "required class='form-input-text'" "time"/><br>
        <label class="form-lbl">Предмет</label>
        <@spring.formSingleSelect "schedule-form.subject", subjects, "required class='form-input-select'"/><br>
        <input class="sbm-btn" type="submit" value="Оновити">

    </form>
</div>
</body>
</html>