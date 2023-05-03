<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <title>Шостий запит</title>
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

<h1 class="table-name-contract">Студенти, які вибрали німецьку і які вибрали більше однієї мови</h1>
<div class="wrapper-teacher">
    <div class="grid-contract-query">
        <div class="grid-item grid-header">Id</div>
        <div class="grid-item grid-header">Студент</div>
        <div class="grid-item grid-header">Мови</div>
        <div class="grid-item grid-header">CreatedAt</div>
        <div class="grid-item grid-header">UpdatedAt</div>
        <#list germanyList as contract>
            <div class="grid-item">${contract.student.getId()}</div>
            <div class="grid-item">${contract.student.getFullName()}</div>
            <div class="grid-item">${contract.group.getLanguage().getName()}</div>
            <div class="grid-item">${contract.createdAt}</div>
            <div class="grid-item">${contract.updatedAt}</div>
        </#list>
    </div>
 <div class="grid-contract-query">
        <div class="grid-item grid-header">Id</div>
        <div class="grid-item grid-header">Студент</div>
        <div class="grid-item grid-header">Мови</div>
        <div class="grid-item grid-header">CreatedAt</div>
        <div class="grid-item grid-header">UpdatedAt</div>
        <#list moreList as contract>
            <div class="grid-item">${contract.id}</div>
            <div class="grid-item">${contract.student}</div>
            <div class="grid-item">
                <#list contract.languages as lan>
                    ${lan.getName()}
                </#list>
            </div>
            <div class="grid-item">${contract.createdAt}</div>
            <div class="grid-item">${contract.updatedAt}</div>
        </#list>
    </div>

</div>
</body>
</html>