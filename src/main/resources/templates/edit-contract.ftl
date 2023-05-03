<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Оновлення</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="main-form">
    <form name="contract-form" class="form-add" action="" method="POST">
        <label class="form-name">Оновити контракт</label>
        <label class="form-lbl">Назва контракту</label>
        <@spring.formInput "contract-form.name" "class='form-input-text' required" "text"/><br>
        <label class="form-lbl">Опис контракту</label>
        <@spring.formInput "contract-form.description" "class='form-input-text' required" "text"/><br>
        <label class="form-lbl">Студент</label>
        <@spring.formSingleSelect "contract-form.student", students, "class='form-input-select' required"/><br>
        <label class="form-lbl">Група</label>
        <@spring.formSingleSelect "contract-form.group", groups, "class='form-input-select' required"/><br>
        <input class="sbm-btn" type="submit" value="Оновити" >

    </form>
</div>
</body>
</html>