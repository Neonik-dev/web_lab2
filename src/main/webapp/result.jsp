<%@ page import="se.ifmo.web.hard_lab2.dto.AllPoints" %>
<%@ page import="se.ifmo.web.hard_lab2.dto.Point" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.List" %>
<%@ page import="se.ifmo.web.hard_lab2.model.UpdateTable" %>
<%@ page import="se.ifmo.web.hard_lab2.filter.ValidatePointFilter" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <meta name="author" content="Лисейчиков Глеб Вячеславович">
    <meta name="description" content="Веб-программирование: Лабораторная работа №2">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/styles.css"/>
    <title>Лабораторная работа №2 | Веб-программирование</title>
</head>

<body>
<jsp:include page="static/header.html"/>
<br>
<div>
    <div id="buttons" class="inline">
        <div id="generateBlock">
            <%
                AllPoints allPoints = (AllPoints) request.getServletContext().getAttribute(UpdateTable.ALL_POINTS_ATTRIBUTE);
                Point newPoint = (Point) request.getAttribute(ValidatePointFilter.VALID_POINT_FROM_REQUEST);
                if (allPoints == null || allPoints.getPoints() == null || newPoint == null || allPoints.getPoints().get(newPoint.r()) == null) {
//                if (allPoints == null) {
            %>
            <h4>
                <span class="outputStub notification">Нет результатов</span>
                <span class="outputStub notification"><%= allPoints %></span>
                <span class="outputStub notification"><%= newPoint %></span>
            </h4>
            <% } else { %>
            <table id='generateTable'>
                <tr>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Точка входит в ОДЗ</th>
                </tr>
                <%
                    List<Point> points = allPoints.getPoints().get(newPoint.r());
                    for (int i = points.size() - 1; i >= 0; i--) {
                        Point point = points.get(i);
                %>
                <tr>
                    <td><%= point.x() %></td>
                    <td><%= point.y() %></td>
                    <td><%= point.r() %></td>
                    <td>
                        <%= point.isInArea() ? "<span class=\"success\">Попал</span>" : "<span class=\"fail\">Промазал</span>" %>
                    </td>
                </tr>
                <% } %>
            </table>
            <% } %>
        </div>
    </div>
    <br>
    <div id="plot" class="inline">
        <img src="${pageContext.request.contextPath}/areas.jpg">
    </div>
</div>
<script src="${pageContext.request.contextPath}/scripts/script.js"></script>
</body>
</html>