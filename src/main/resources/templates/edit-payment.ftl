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
    <form name="payment-form" class="form-add" action="" method="POST">
        <label class="form-name">Оновлення оплати</label>
        <label class="form-lbl">Контракт</label>
        <@spring.formSingleSelect "payment-form.contract", contracts, "class='form-input-select' required"/><br>
        <label class="form-lbl">Опис оплати</label>
        <@spring.formInput "payment-form.description" "class='form-input-text' required" "text"/><br>
        <label class="form-lbl">Сума оплати</label>
        <@spring.formInput "payment-form.paidAmount" "class='form-input-text' required min='0'" "number"/>
        <div class="check-payment">
            <input id="post" type="checkbox" name="postponeCheck">
            <label for="post" class="check-label">Відтермінування</label><br>
            <input id="check-priv" type="checkbox" name="privilegeCheck">
            <label for="check-priv" class="check-label">Пільги</label>
        </div>

        <input class="sbm-btn" type="submit" value="Оновити">
    </form>
</div>
</body>
</html>