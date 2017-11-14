<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="termslist-content-wrapper">
    <button type="submit" onclick="location.href = '/term';">Create new term</button>
    <br>
    <br>

    <div class="termslist-table-wrapper">

        <table>
            <thead>
            <th>ID semester</th>
            <th>Name semester</th>
            <th>Duration</th>
            </thead>
            <tbody>
            <c:forEach items="${terms}" var="term">
                <tr onclick="document.location = 'term?id=${term.id}';">
                    <td>
                        <span>${term.id}</span>
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

