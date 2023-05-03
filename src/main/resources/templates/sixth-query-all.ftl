<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">

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

<h1 class="table-name-student">Студенти, які прослухали більше трьох рівнів</h1>
  <div class="grid-student-query">
    <div class="grid-item grid-header">Id</div>
    <div class="grid-item grid-header">Прізвище</div>
    <div class="grid-item grid-header">Ім'я</div>
    <div class="grid-item grid-header">По батькові</div>
    <div class="grid-item grid-header">Вік</div>
    <div class="grid-item grid-header">Телефон</div>
    <div class="grid-item grid-header">Email</div>
    <div class="grid-item grid-header">Опис</div>
    <div class="grid-item grid-header">CreatedAt</div>
    <div class="grid-item grid-header">UpdatedAt</div>
    <#list students as student>
      <div class="grid-item">${student.id}</div>
      <div class="grid-item">${student.lastName}</div>
      <div class="grid-item">${student.firstName}</div>
      <div class="grid-item">${student.patronymic}</div>
      <div class="grid-item">${student.age}</div>
      <div class="grid-item">${student.phone}</div>
      <div class="grid-item">${student.email}</div>
      <div class="grid-item">${student.description}</div>
      <div class="grid-item">${student.createdAt}</div>
      <div class="grid-item">${student.updatedAt}</div>
    </#list>
  </div>



</body>
</html>