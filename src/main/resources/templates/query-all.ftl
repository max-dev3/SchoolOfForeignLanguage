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
    <label class="form-name">Всі запити</label>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/query/1"><button class="link-btn">Групи по мові</button></a>
    </div>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/query/2"><button class="link-btn">Групи по викладачу</button></a>
    </div>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/query/3"><button class="link-btn">Вартість мови</button></a>
    </div>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/query/5"><button class="link-btn">Інформація про нездачу іспитів</button></a>
    </div>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/query/6"><button class="link-btn">Інформація про викладачів</button></a>
    </div>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/query/7"><button class="link-btn">Інформація про оплати</button></a>
    </div>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/query/8"><button class="link-btn">Студенти, які обрали більше 3 рівнів</button></a>
    </div>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/query/9"><button class="link-btn">Студенти, які обрали німецьку</button></a>
    </div>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/query/10"><button class="link-btn">Групи з мін/макс кількістю студентів</button></a>
    </div>
    <div class="div-center">
        <a href="/ui/v1/${dbname}/query/11"><button class="link-btn">Розклад занять</button></a>
    </div>

</div>
</body>
</html>