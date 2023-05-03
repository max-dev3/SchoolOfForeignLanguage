<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
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
        <button class="new-contract">Новий</button>
    </a>
    <a href="/ui/v1/${dbname}/contracts">
        <button class="old-contract current-contract">Існуючий</button>
    </a>
</div>
<div class="main-form">
    <form name="contract-form" class="form-add" action="" method="POST">
        <label class="form-name">Додати контракт</label>
        <label class="form-lbl">Назва контракту</label>
        <@spring.formInput "contract-form.name" "class='form-input-text' required" "text"/><br>
        <label class="form-lbl">Опис контракту</label>
        <@spring.formInput "contract-form.description" "class='form-input-text' required" "text"/><br>
        <label class="form-lbl">Студент</label>
        <@spring.formSingleSelect "contract-form.student", students, "class='form-input-select' required"/><br>
        <label class="form-lbl">Група</label>
        <@spring.formSingleSelect "contract-form.group", groups, "class='form-input-select' required"/><br>
        <div class="check-payment">
            <input id="post" type="checkbox" name="postponeCheck">
            <label for="post" class="check-label">Відтермінування</label><br>
            <input id="check-priv" type="checkbox" name="privilegeCheck">
            <label for="check-priv" class="check-label">Пільги</label>
        </div>
        <input class="sbm-btn" type="submit" value="Створити" >

    </form>
</div>
</body>
</html>