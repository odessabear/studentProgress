<%--
  Created by IntelliJ IDEA.
  User: alexander.mikhailov
  Date: 06.10.2017
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="title" style="font-size:120%">
    <c:if test="${term.id == 0}"><p> Для создания семестра заполните все поля и нажмите кнопку "Создать".</p></c:if>
</div>

<div class="log-form-wrapper">

    <form class="term-create-form" method="POST" id="createTermForm" action="term">
        <div class="term-name-input">
            <label for="name">Имя семестра</label><br>
            <input id="name" name="name" type="text" value="${term.name}"/>
        </div>

        <div class="term-length-input">
            <label for="duration">Длительность в неделях</label><br>
            <input id="duration" name="durationLength" type="text" value="${term.duration}"/>
        </div>
        <div class="term-discipline-input">
            <label>Список дисцилин</label><br>
            <c:choose>
                <c:when test="${term.id == 0}">
                    <input id="discipline_${discipline.id}" name="disciplineName" type="text" value="${discipline.name}"/>
                    <br />
                </c:when>
                <c:otherwise>
                    <c:forEach items="${term.disciplines}" var="discipline">
                        <input id="discipline_${discipline.id}" name="disciplineName" type="text" value="${discipline.name}"/>
                        <br>
                    </c:forEach>
                    <br />
                </c:otherwise>
            </c:choose>


        </div>

        <div class="term-submit-input">
            <!-- 0 term id means we're about to create a new term. and right now we have empty term stub -->
            <c:if test="${term.id == 0}"><input type='submit' value="Создать"> </c:if>
        </div>
    </form>
    <script>

        // $( document ).ready(function() {
        //
        // var testForm = document.getElementById('createTermForm');
        // testForm.onsubmit = function (event) {
        // event.preventDefault();
        // var formData = new FormData(document.getElementById('createTermForm'));
        // console.log("current formdata = " + formData);
        // // var request = new XMLHttpRequest();
        // // request.open('POST', '/term', /* async = */ false);
        // //
        // //
        // // request.send(formData);
        //
        // $.ajax({
        // async: true,
        // type: "POST",
        // url: "/term",
        // contentType: "application/json",
        // data: JSON.stringify( formData )
        // });
        //
        // // console.log(request.response);
        // };
        // });


    </script>


</div>
