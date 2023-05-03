<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>П'ятий запит</title>
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
<h1 class="table-name-query">Інформація про оплату</h1>
<div class="wrapper-teacher">

    <div class="grid-teacher-query">
        <div class="grid-item grid-header-group">Id</div>
        <div class="grid-item grid-header-group">Студент</div>
        <div class="grid-item grid-header-group">Група</div>
        <div class="grid-item grid-header-group">Загальна сума</div>
        <div class="grid-item grid-header-group">Оплачено</div>
        <div class="grid-item grid-header-group">Статус</div>
        <div class="grid-item grid-header-group">Відтермінування</div>
        <div class="grid-item grid-header-group">Пільги</div>
        <div class="grid-item grid-header-group">CreatedAt</div>
        <div class="grid-item grid-header-group">UpdatedAt</div>
        <#list payments1 as payment>
            <div class="grid-item">${payment.id}</div>
            <div class="grid-item">${payment.contract.getStudent().getFullName()}</div>
            <div class="grid-item">${payment.contract.getGroup().getName()}</div>

            <div class="grid-item">${payment.totalAmount}</div>
            <div class="grid-item">${payment.paidAmount}</div>
            <div class="grid-item">${payment.paymentStatus}</div>
            <#if payment.postponePayment >
                <div class="grid-item">Є</div>
            <#else>
                <div class="grid-item">Немає</div>
            </#if>
            <#if payment.privilege>
                <div class="grid-item">Є</div>
            <#else>
                <div class="grid-item">Немає</div>
            </#if>
            <div class="grid-item">${payment.createdAt}</div>
            <div class="grid-item">${payment.updatedAt}</div>
        </#list>
    </div>
  <div class="grid-teacher-query">
        <div class="grid-item grid-header-group">Id</div>
        <div class="grid-item grid-header-group">Студент</div>
        <div class="grid-item grid-header-group">Група</div>
        <div class="grid-item grid-header-group">Загальна сума</div>
        <div class="grid-item grid-header-group">Оплачено</div>
        <div class="grid-item grid-header-group">Статус</div>
        <div class="grid-item grid-header-group">Відтермінування</div>
        <div class="grid-item grid-header-group">Пільги</div>
        <div class="grid-item grid-header-group">CreatedAt</div>
        <div class="grid-item grid-header-group">UpdatedAt</div>
        <#list payments2 as payment>
            <div class="grid-item">${payment.id}</div>
            <div class="grid-item">${payment.contract.getStudent().getFullName()}</div>
            <div class="grid-item">${payment.contract.getGroup().getName()}</div>

            <div class="grid-item">${payment.totalAmount}</div>
            <div class="grid-item">${payment.paidAmount}</div>
            <div class="grid-item">${payment.paymentStatus}</div>
            <#if payment.postponePayment >
                <div class="grid-item">Є</div>
            <#else>
                <div class="grid-item">Немає</div>
            </#if>
            <#if payment.privilege>
                <div class="grid-item">Є</div>
            <#else>
                <div class="grid-item">Немає</div>
            </#if>
            <div class="grid-item">${payment.createdAt}</div>
            <div class="grid-item">${payment.updatedAt}</div>
        </#list>
    </div>
  <div class="grid-teacher-query">
        <div class="grid-item grid-header-group">Id</div>
        <div class="grid-item grid-header-group">Студент</div>
        <div class="grid-item grid-header-group">Група</div>
        <div class="grid-item grid-header-group">Загальна сума</div>
        <div class="grid-item grid-header-group">Оплачено</div>
        <div class="grid-item grid-header-group">Статус</div>
        <div class="grid-item grid-header-group">Відтермінування</div>
        <div class="grid-item grid-header-group">Пільги</div>
        <div class="grid-item grid-header-group">CreatedAt</div>
        <div class="grid-item grid-header-group">UpdatedAt</div>
        <#list payments3 as payment>
            <div class="grid-item">${payment.id}</div>
            <div class="grid-item">${payment.contract.getStudent().getFullName()}</div>
            <div class="grid-item">${payment.contract.getGroup().getName()}</div>

            <div class="grid-item">${payment.totalAmount}</div>
            <div class="grid-item">${payment.paidAmount}</div>
            <div class="grid-item">${payment.paymentStatus}</div>
            <#if payment.postponePayment >
                <div class="grid-item">Є</div>
            <#else>
                <div class="grid-item">Немає</div>
            </#if>
            <#if payment.privilege>
                <div class="grid-item">Є</div>
            <#else>
                <div class="grid-item">Немає</div>
            </#if>
            <div class="grid-item">${payment.createdAt}</div>
            <div class="grid-item">${payment.updatedAt}</div>
        </#list>
    </div>
  <div class="grid-teacher-query">
        <div class="grid-item grid-header-group">Id</div>
        <div class="grid-item grid-header-group">Студент</div>
        <div class="grid-item grid-header-group">Група</div>
        <div class="grid-item grid-header-group">Загальна сума</div>
        <div class="grid-item grid-header-group">Оплачено</div>
        <div class="grid-item grid-header-group">Статус</div>
        <div class="grid-item grid-header-group">Відтермінування</div>
        <div class="grid-item grid-header-group">Пільги</div>
        <div class="grid-item grid-header-group">CreatedAt</div>
        <div class="grid-item grid-header-group">UpdatedAt</div>
        <#list payments4 as payment>
            <div class="grid-item">${payment.id}</div>
            <div class="grid-item">${payment.contract.getStudent().getFullName()}</div>
            <div class="grid-item">${payment.contract.getGroup().getName()}</div>

            <div class="grid-item">${payment.totalAmount}</div>
            <div class="grid-item">${payment.paidAmount}</div>
            <div class="grid-item">${payment.paymentStatus}</div>
            <#if payment.postponePayment >
                <div class="grid-item">Є</div>
            <#else>
                <div class="grid-item">Немає</div>
            </#if>
            <#if payment.privilege>
                <div class="grid-item">Є</div>
            <#else>
                <div class="grid-item">Немає</div>
            </#if>
            <div class="grid-item">${payment.createdAt}</div>
            <div class="grid-item">${payment.updatedAt}</div>
        </#list>
    </div>
  <div class="grid-teacher-query">
        <div class="grid-item grid-header-group">Id</div>
        <div class="grid-item grid-header-group">Студент</div>
        <div class="grid-item grid-header-group">Група</div>
        <div class="grid-item grid-header-group">Загальна сума</div>
        <div class="grid-item grid-header-group">Оплачено</div>
        <div class="grid-item grid-header-group">Статус</div>
        <div class="grid-item grid-header-group">Відтермінування</div>
        <div class="grid-item grid-header-group">Пільги</div>
        <div class="grid-item grid-header-group">CreatedAt</div>
        <div class="grid-item grid-header-group">UpdatedAt</div>
        <#list payments5 as payment>
            <div class="grid-item">${payment.id}</div>
            <div class="grid-item">${payment.contract.getStudent().getFullName()}</div>
            <div class="grid-item">${payment.contract.getGroup().getName()}</div>

            <div class="grid-item">${payment.totalAmount}</div>
            <div class="grid-item">${payment.paidAmount}</div>
            <div class="grid-item">${payment.paymentStatus}</div>
            <#if payment.postponePayment >
                <div class="grid-item">Є</div>
            <#else>
                <div class="grid-item">Немає</div>
            </#if>
            <#if payment.privilege>
                <div class="grid-item">Є</div>
            <#else>
                <div class="grid-item">Немає</div>
            </#if>
            <div class="grid-item">${payment.createdAt}</div>
            <div class="grid-item">${payment.updatedAt}</div>
        </#list>
    </div>


</div>
</body>
</html>