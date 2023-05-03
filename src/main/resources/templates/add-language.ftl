<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Створення</title>
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
      <label class="form-name">Додати мову</label>
      <label for="name-inp" class="form-lbl">Назва мови</label>
      <input type="text" class="form-input-text" name="name" id="name-inp" placeholder="Англійська" required><br>
      <label for="desc-inp" class="form-lbl">Опис</label>
      <input type="text" class="form-input-text" name="description" id="desc-inp" placeholder="Перша мова" required><br>
      <label class="form-lbl">Виберіть мінімум 4 рівні</label>
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
      <label for="price" class="form-lbl">Початкова ціна за рівень</label>
      <input id="price" type="number" class="form-input-text" name="startPrice" placeholder="100" required min="1"><br>
      <input class="sbm-btn" type="submit"  value="Створити">

  </form>
</div>
</body>
</html>