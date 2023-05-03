<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Викладачі</title>
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
<div>
  <form name="surname-form" action="" method="POST">
    <@spring.formInput "surname-form.firstName" "class='search' placeholder='Пошук'" "text"/>
  </form>
</div>
<h1 class="table-name">Таблиця викладачів</h1>
<a href="/ui/v1/${dbname}/teachers">
  <button class="btn-create">Створити</button>
</a>
<div class="grid-full">
  <div class="grid-item grid-header">Id</div>
  <div class="grid-item grid-header">Прізвище</div>
  <div class="grid-item grid-header">Ім'я</div>
  <div class="grid-item grid-header">По батькові</div>
  <div class="grid-item grid-header">Номер телефону</div>
  <div class="grid-item grid-header">Email</div>
  <div class="grid-item grid-header">Досвід роботи</div>
  <div class="grid-item grid-header">Опис</div>
  <div class="grid-item grid-header">CreatedAt</div>
  <div class="grid-item grid-header">UpdatedAt</div>
  <div class="grid-item grid-header">Видалити</div>
  <div class="grid-item grid-header">Оновити</div>
  <#list teachers as teacher>
    <div class="grid-item">${teacher.id}</div>
    <div class="grid-item">${teacher.lastName}</div>
    <div class="grid-item">${teacher.firstName}</div>
    <div class="grid-item">${teacher.patronymic}</div>
    <div class="grid-item">${teacher.phone}</div>
    <div class="grid-item">${teacher.email}</div>
    <div class="grid-item">${teacher.experience}</div>
    <div class="grid-item">${teacher.description}</div>
    <div class="grid-item">${teacher.createdAt}</div>
    <div class="grid-item">${teacher.updatedAt}</div>
    <div class="grid-item">

      <a href="/ui/v1/${dbname}/teachers/delete/${teacher.id}">
        <button class="delete-btn">Видалити</button>
      </a>
    </div>
    <div class="grid-item">

      <a href="/ui/v1/${dbname}/teachers/edit/${teacher.id}">
        <button class="update-btn">Оновити</button>
      </a>
    </div>
  </#list>
</div>
</body>
</html>