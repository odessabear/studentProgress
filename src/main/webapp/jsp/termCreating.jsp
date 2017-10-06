<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:53
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
        <p> Для создания семестра заполните все поля и нажмите кнопку "Создать".</p>
        <pre><form action="/action_page.php" method="get">
     Длительность (в неделях)       <input type="text" name="lname"><br>

  Дисциплины в семестре
                                    <select name="select" size="8" multiple>
    <option selected value="s1">Информатика</option>
    <option value="s2">Политология</option>
    <option value="s3">Социология</option>
    <option value="s4">Высшая Математика</option>
	<option value="s4">Теория Алгоритмизации</option>
	<option value="s4">Теория Игр</option>
	<option value="s4">Булева Алгебра</option>
	<option value="s4">Системный анализ</option>
   </select><br>


  <input type="submit" value="Создать"><br></pre>

        </form><br>

    </div>
</center>
</body>
</html>
