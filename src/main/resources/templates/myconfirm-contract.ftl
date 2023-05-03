<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Підтвердження</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
<div class="confirm-div">
    <label class="form-name">Підтвердження даних</label>
    <label class="show-lbl">Назва контракту: <b>${contractName}</b></label><br>
    <label class="show-lbl">ПІБ студента: <b>${student}</b></label><br>
    <label class="show-lbl">Номер групи: <b>${group}</b></label><br>
    <label class="show-lbl">Загальна ціна: <b>${price}</b></label><br>
    <label class="show-lbl">Початок навчання: <b>${startDate}</b></label><br>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/contracts/">
            <button class="link-btn">
                Підтвердити
            </button>
        </a>
    </div>
</div>
</body>
</html>