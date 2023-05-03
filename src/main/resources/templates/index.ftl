<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Головна</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
</head>
<body>
    <div class="header">
        <div class="imglogo"></div>
        <h1 class="textlogo">Поліглот</h1>
        <div class="menu">
            <ul>
                <li class="mainbold"><a href="index.ftl">Головна</a></li>
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
                <li><a href="/ui/v1/mysql/query/">Запити</a></li>
                <li><a href="/ui/v1/changing/">Вибір БД</a></li>
                <li><a href="/ui/v1/${dbname}/login/">Вихід</a></li>
            </ul>
        </div>
    </div>
    <div class="main">
        <div class="offer">
            <p id="offer">Приєднуйтесь до нашої дружньої родини</p>
            <p id="descriptor">Онлайн школа з іноземних мов "Поліглот" якісно покращить знання іноземної мови!</p>
            <div class="btnsign">
                <a href="/ui/v1/${dbname}/contracts/new">Записатися</a>
            </div>
        </div>
        <div class="offerphoto"></div>
    </div>
    <div class="footer">
        <p class="footertext">© 2021 Усі права захищені. Designed by Maksym Fushtei</p>
    </div>
</body>
</html>