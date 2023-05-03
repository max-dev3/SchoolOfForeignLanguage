<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Восьмий запит</title>
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

<h1 class="table-name-contract">Таблиця груп з мінімальною і максимальною кількістю студентів</h1>
<div class="wrapper-teacher">
    <div class="grid-group-query1">
        <div class="grid-item grid-header-group" >Id</div>
        <div class="grid-item grid-header-group">Назва</div>
        <div class="grid-item grid-header-group">Опис</div>
        <div class="grid-item grid-header-group">Мова</div>
        <div class="grid-item grid-header-group">Рівень</div>
        <div class="grid-item grid-header-group">Загальна сума</div>
        <div class="grid-item grid-header-group">Початок навчання</div>
        <div class="grid-item grid-header-group">Кінець навчання</div>
        <div class="grid-item grid-header-group">Кількість студентів</div>
        <div class="grid-item grid-header-group">Викладач</div>
        <div class="grid-item grid-header-group">Заповненість групи</div>
        <div class="grid-item grid-header-group">Статус навчання</div>
        <div class="grid-item grid-header-group">CreatedAt</div>
        <div class="grid-item grid-header-group">UpdatedAt</div>
        <#list groups as group>
            <div class="grid-item">${group.id}</div>
            <div class="grid-item">${group.name}</div>
            <div class="grid-item">${group.description}</div>
            <div class="grid-item">${group.language.getName()}</div>
            <div class="grid-item">${group.level}</div>
            <div class="grid-item">${group.totalPrice}</div>
            <div class="grid-item">${group.startDate}</div>
            <div class="grid-item">${group.endDate}</div>
            <div class="grid-item">${group.amountOfStudents}</div>
            <div class="grid-item">${group.teacher.getFullName()}</div>
            <div class="grid-item">${group.groupCapacity}</div>
            <div class="grid-item">${group.educationStatus}</div>
            <div class="grid-item">${group.createdAt}</div>
            <div class="grid-item">${group.updatedAt}</div>
        </#list>
    </div>
    <div class="grid-group-query1">
        <div class="grid-item grid-header-group" >Id</div>
        <div class="grid-item grid-header-group">Назва</div>
        <div class="grid-item grid-header-group">Опис</div>
        <div class="grid-item grid-header-group">Мова</div>
        <div class="grid-item grid-header-group">Рівень</div>
        <div class="grid-item grid-header-group">Загальна сума</div>
        <div class="grid-item grid-header-group">Початок навчання</div>
        <div class="grid-item grid-header-group">Кінець навчання</div>
        <div class="grid-item grid-header-group">Кількість студентів</div>
        <div class="grid-item grid-header-group">Викладач</div>
        <div class="grid-item grid-header-group">Заповненість групи</div>
        <div class="grid-item grid-header-group">Статус навчання</div>
        <div class="grid-item grid-header-group">CreatedAt</div>
        <div class="grid-item grid-header-group">UpdatedAt</div>
        <#list groups1 as group>
            <div class="grid-item">${group.id}</div>
            <div class="grid-item">${group.name}</div>
            <div class="grid-item">${group.description}</div>
            <div class="grid-item">${group.language.getName()}</div>
            <div class="grid-item">${group.level}</div>
            <div class="grid-item">${group.totalPrice}</div>
            <div class="grid-item">${group.startDate}</div>
            <div class="grid-item">${group.endDate}</div>
            <div class="grid-item">${group.amountOfStudents}</div>
            <div class="grid-item">${group.teacher.getFullName()}</div>
            <div class="grid-item">${group.groupCapacity}</div>
            <div class="grid-item">${group.educationStatus}</div>
            <div class="grid-item">${group.createdAt}</div>
            <div class="grid-item">${group.updatedAt}</div>
        </#list>
    </div>
</div>
</body>
</html>