<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Другий запит</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>

<div class="header">
    <h1 class="textlogo">Поліглот</h1>
    <div class="menu">
        <ul>
            <li><a href="/ui/v1/${dbname}/main/">Головна</a></li>
            <li class="dropdown">Таблиці
                <div class="dropdown-content">
                    <a href="/ui/v1/${dbname}/contracts/">Контракти</a>
                    <a href="/ui/v1/${dbname}/students/">Студенти</a>
                    <a href="/ui/v1/${dbname}/groups/">Групи</a>
                    <a href="/ui/v1/${dbname}/teachers/">Викладачі</a>
                    <a href="/ui/v1/${dbname}/payments/">Оплати</a>
                    <a href="/ui/v1/${dbname}/languages/">Мови</a>
                    <a href="/ui/v1/${dbname}/subjects/">Предмети</a>
                    <a href="/ui/v1/${dbname}/schedules/">Розклад</a>
                    <a href="/ui/v1/${dbname}/exams/">Екзамени</a>
                    <a href="/ui/v1/${dbname}/student-exams/">Оцінки</a>
                </div>
            </li>
            <li class="mainbold"><a href="/ui/v1/mysql/query/">Запити</a></li>
            <li><a href="/ui/v1/changing/">Вибір БД</a></li>
            <li><a href="/ui/v1/${dbname}/login/">Вихід</a></li>
        </ul>
    </div>
</div>
    <div class="confirm-div">
        <label class="form-name">Повна вартість мови</label>
        <label class="second-query-lbl">${language}: ${totalPrice}</label>
        <hr>
        <label class="form-name">Ціна за рівнями</label>
        <#list prices as price>
            <label class="second-query-lbl">${price}</label><br>
        </#list>
        <hr>
        <label class="form-name">Ціна за місяць</label>
        <#list priceMonth as price>
            <label class="second-query-lbl">${price}</label><br>
        </#list>

</div>
</body>
</html>