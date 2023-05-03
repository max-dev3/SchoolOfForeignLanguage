<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Екзамени</title>
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
            <li><a href="/ui/v1/mysql/query/">Запити</a></li>
            <li><a href="/ui/v1/changing/">Вибір БД</a></li>
            <li><a href="/ui/v1/${dbname}/login/">Вихід</a></li>
        </ul>
    </div>
</div>

<h1 class="table-name">Таблиця екзаменів</h1>
<a href="/ui/v1/${dbname}/exams">
    <button class="btn-create">Створити</button>
</a>
<div class="grid-exams">
    <div class="grid-item grid-header">Id</div>
    <div class="grid-item grid-header">Назва екзамену</div>
    <div class="grid-item grid-header">Опис</div>
    <div class="grid-item grid-header">Група</div>
    <div class="grid-item grid-header">Предмет</div>
    <div class="grid-item grid-header">Дата екзамену</div>
    <div class="grid-item grid-header">CreatedAt</div>
    <div class="grid-item grid-header">UpdatedAt</div>
    <div class="grid-item grid-header">Видалити</div>
    <div class="grid-item grid-header">Оновити</div>
    <#list exams as exam>
        <div class="grid-item">${exam.id}</div>
        <div class="grid-item">${exam.name}</div>
        <div class="grid-item">${exam.description}</div>
        <div class="grid-item">${exam.group.getName()}</div>
        <div class="grid-item">${exam.subject.getName()}</div>
        <div class="grid-item">${exam.dateOfExam}</div>
        <div class="grid-item">${exam.createdAt}</div>
        <div class="grid-item">${exam.updatedAt}</div>
        <div class="grid-item">

            <a href="/ui/v1/${dbname}/exams/delete/${exam.id}">
                <button class="delete-btn">Видалити</button>
            </a>
        </div>
        <div class="grid-item">

            <a href="/ui/v1/${dbname}/exams/edit/${exam.id}">
                <button class="update-btn">Оновити</button>
            </a>
        </div>
    </#list>
</div>
<div>

</div>
</body>
</html>