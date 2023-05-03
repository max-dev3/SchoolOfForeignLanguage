<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Десятий запит</title>
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
<h1 class="table-name-contract">Розклад занять по вибраній групі і по вибраному викладачу</h1>
<div class="wrapper-teacher">
  <div class="grid-schedules-query">
    <div class="grid-item grid-header">Id</div>
    <div class="grid-item grid-header">День тижня</div>
    <div class="grid-item grid-header">Група</div>
    <div class="grid-item grid-header">Номер кімнати</div>
    <div class="grid-item grid-header">Початок заняття</div>
    <div class="grid-item grid-header">Кінець заняття</div>
    <div class="grid-item grid-header">Предмет</div>
    <div class="grid-item grid-header">Викладач</div>
    <div class="grid-item grid-header">CreatedAt</div>
    <div class="grid-item grid-header">UpdatedAt</div>

    <#list schedules as schedule>
      <div class="grid-item">${schedule.id}</div>
      <div class="grid-item">${schedule.day}</div>
      <div class="grid-item">${schedule.group.getName()}</div>
      <div class="grid-item">${schedule.classroom}</div>
      <div class="grid-item">${schedule.startLesson}</div>
      <div class="grid-item">${schedule.endLesson}</div>
      <div class="grid-item">${schedule.subject.getName()}</div>
      <div class="grid-item">${schedule.teacher.getFullName()}</div>
      <div class="grid-item">${schedule.createdAt}</div>
      <div class="grid-item">${schedule.updatedAt}</div>
    </#list>
  </div>
  <div class="grid-schedules-query">
    <div class="grid-item grid-header">Id</div>
    <div class="grid-item grid-header">День тижня</div>
    <div class="grid-item grid-header">Група</div>
    <div class="grid-item grid-header">Номер кімнати</div>
    <div class="grid-item grid-header">Початок заняття</div>
    <div class="grid-item grid-header">Кінець заняття</div>
    <div class="grid-item grid-header">Предмет</div>
    <div class="grid-item grid-header">Викладач</div>
    <div class="grid-item grid-header">CreatedAt</div>
    <div class="grid-item grid-header">UpdatedAt</div>

    <#list schedules2 as schedule>
      <div class="grid-item">${schedule.id}</div>
      <div class="grid-item">${schedule.day}</div>
      <div class="grid-item">${schedule.group.getName()}</div>
      <div class="grid-item">${schedule.classroom}</div>
      <div class="grid-item">${schedule.startLesson}</div>
      <div class="grid-item">${schedule.endLesson}</div>
      <div class="grid-item">${schedule.subject.getName()}</div>
      <div class="grid-item">${schedule.teacher.getFullName()}</div>
      <div class="grid-item">${schedule.createdAt}</div>
      <div class="grid-item">${schedule.updatedAt}</div>
    </#list>
  </div>
</div>

</body>
</html>