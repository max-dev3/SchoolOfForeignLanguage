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
<div class="main-form">
    <form name="fullPayment-form" class="form-add" action="" method="POST">
        <label class="form-name">Оплатити навчання</label>
        <label class="show-lbl">Контракт: <b>${contract}</b></label><br>
        <label class="show-lbl">Залишилося: ${remaining}</label><br>
        <label class="form-lbl">Ввести суму оплати</label>
        <@spring.formInput "fullPayment-form.paidAmount" "required class='form-input-text'" "number"/><br>
        <input class="sbm-btn" type="submit" value="Оновити">

    </form>
</div>
</body>
</html>