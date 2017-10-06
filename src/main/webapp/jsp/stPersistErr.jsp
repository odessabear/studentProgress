<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <div style="font-size:120%">
        <p> Для создания студента заполните все поля и нажмите кнопку "Создать".</p>
        <pre><form action="/action_page.php" method="get">
  Фамилия          <input type="text" name="lname"><br>

  Имя              <input type="text" name="fname"><br>

  Группа           <input type="text" name="group"><br>

  Дата поступления <input type="text" name="incName"><br>

                   <input type="submit" value="Создать"><br></pre>

        </form><br>
        <strong style="color:#ff0000">Поля не должны быть пустыми !!!</strong>
    </div>
</center>
</body>
</html>
