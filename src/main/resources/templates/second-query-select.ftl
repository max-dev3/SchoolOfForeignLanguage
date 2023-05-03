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
    <form name="query-form" class="form-add" action="" method="POST">
        <label class="form-name">Вибір викладача</label>

        <@spring.formSingleSelect "query-form.teacher", teachers, "required class='form-input-select'"/><br>

        <input class="sbm-btn" type="submit" value="Створити">

    </form>
</div>
</body>
</html>