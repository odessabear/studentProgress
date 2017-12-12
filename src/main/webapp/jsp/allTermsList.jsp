<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="termslist-content-wrapper">

    <div class="admin-panel_3">
        <c:if test="${role eq '1'}">
            <button class="termButtons" type="submit" onclick="location.href = '/term';">Create a new term</button>

            <button class="termButtons" type="submit" onclick="modifyTerm()">Modify term</button>

            <button class="termButtons" type="submit" onclick="disableTerm()">Delete term</button>
        </c:if>
    </div>
    <br>
    <div id="formDeleteDiv"></div>
    <div id="formModifyDiv">
        <form id="formModify" action="/term-modifying" method="get">
            <input type="hidden" name="checkboxesModify" id="checkboxesModify"/>
        </form>
    </div>
    <br>


    <div class="termslist-table-wrapper">

        <table>
            <thead>
            <th class="control"></th>
            <th>ID semester</th>
            <th>Name semester</th>
            <th>Duration</th>
            </thead>
            <tbody>

            <c:forEach items="${terms}" var="term">
                <%-- <tr onclick="document.location = 'term?id=${term.id}';">--%>
                <tr>
                    <td>
                        <input type="checkbox" name="termToSelect" value="${term.id}">
                    </td>
                    <td>
                        <span>${term.id}</span>
                        <button onclick="document.location = 'term?id=${term.id}';">Look Term</button>
                    </td>
                    <td>
                        <span>${term.name}</span>
                    </td>
                    <td>
                        <span>${term.duration}</span>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

