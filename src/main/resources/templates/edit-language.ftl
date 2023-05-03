<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Оновлення</title>
    <style type="text/css">
        <#include "css/style.css">
    </style>
    <script type="text/javascript">
        <#include "js/minimum.js">
    </script>

</head>
<body>
<div class="main-form">
    <form name="language-form" class="form-add" action="" method="POST" onsubmit="return click1()">
        <label class="form-name">Оновити мову</label>
        <label class="form-lbl">Назва групи</label>
        <@spring.formInput "language-form.name" "required class='form-input-text' placeholder='Англійська'" "text"/><br>
        <label class="form-lbl">Опис групи</label>
        <@spring.formInput "language-form.description" "required class='form-input-text'
         placeholder='Перша мова'" "text"/><br>
        <div class="div-check">

            <input id="first" type="checkbox"  name="firstCheckbox">
            <label for="first" class="check-label">A1</label>
            <input id="second" type="checkbox" name="secondCheckbox">
            <label for="second" class="check-label">A2</label>
            <input id="third" type="checkbox" name="thirdCheckbox">
            <label for="third" class="check-label">B1</label><br>
            <input id="fourth" type="checkbox" name="fourthCheckbox">
            <label for="fourth" class="check-label">B2</label>
            <input id="fifth" type="checkbox" name="fifthCheckbox">
            <label for="fifth" class="check-label">C1</label>
            <input id="sixth" type="checkbox" name="sixthCheckbox">
            <label for="sixth" class="check-label">C2</label>
        </div>
        <br>
        <label class="form-lbl">Початкова ціна за рівень</label>
        <@spring.formInput "language-form.startPricePerLevel" "class='form-input-text' required min='0'" "number"/>
        <input class="sbm-btn" type="submit"  value="Оновлення">

    </form>
</div>
</body>
</html>