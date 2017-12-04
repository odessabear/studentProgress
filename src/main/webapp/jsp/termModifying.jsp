
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="title" style="font-size:120%">
    <p> Для модификации семестра отредактируйте данные и нажмите кнопку "Создать".</p>
</div>
<div class="log-form-wrapper">
    <form class="term-create-form" action="/term-modifying" method="post">
        <input type="hidden" name="id" value="${term.id}">
        <div class="term-name-input">
            <label>Название семестра</label><input type="text" name="termsName" value="${term.name}">
        </div>
        <div class="term-length-input">
            <label>Длительность(в неделях)</label><input type="text" name="duration" value="${term.duration}">
        </div>
        <div>
            <div class="term-discipline-input">
                <label>Дисциплины в семестре</label>
                <select id="selectedMap" name="disciplineList" multiple="multiple">
                    <c:forEach items="${term.disciplines}" var="discipline">
                        <option value="${discipline.id}">${discipline.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="term-submit-input">
                <input type="submit" value="Применить">
            </div>
    </form>
</div>