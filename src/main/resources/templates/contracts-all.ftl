<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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

<h1 class="table-name">Таблиця контрактів</h1>
<a href="/ui/v1/${dbname}/contracts">
    <button class="btn-create">Створити</button>
</a>
<div class="grid">
    <div class="grid-item grid-header" >Id</div>
    <div class="grid-item grid-header">Назва</div>
    <div class="grid-item grid-header">Опис</div>
    <div class="grid-item grid-header">Студент</div>
    <div class="grid-item grid-header">Група</div>
    <div class="grid-item grid-header">Додати нову мову</div>
    <div class="grid-item grid-header">CreatedAt</div>
    <div class="grid-item grid-header">UpdatedAt</div>
    <div class="grid-item grid-header">Видалити</div>
    <div class="grid-item grid-header">Оновити</div>
    <#list contracts as contract>
        <div class="grid-item">${contract.id}</div>
        <div class="grid-item">${contract.name}</div>
        <div class="grid-item">${contract.description}</div>
        <div class="grid-item">${contract.getStudent().getFullName()}</div>
        <div class="grid-item">${contract.getGroup().getName()}</div>
        <div class="grid-item">

                <a href="/ui/v1/${dbname}/contracts/new/${contract.student.id}">
                    <button class="btn-add">Додати</button>
                </a>

        </div>
        <div class="grid-item">${contract.createdAt}</div>
        <div class="grid-item">${contract.updatedAt}</div>
        <div class="grid-item">

            <a href="/ui/v1/${dbname}/contracts/delete/${contract.id}">
                <button class="delete-btn">Видалити</button>
            </a>
        </div>
        <div class="grid-item">

                <a href="/ui/v1/${dbname}/contracts/edit/${contract.id}">
                    <button class="update-btn">Оновити</button>
                </a>
        </div>
    </#list>
</div>
<div>

</div>
</body>
</html>