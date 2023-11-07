<%@ page import="se.ifmo.web.hard_lab2.dto.Benchmarks" %>
<%@ page import="se.ifmo.web.hard_lab2.filter.BenchmarkFilter" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: neonik
  Date: 07.11.2023
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
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
                Benchmarks benchmarks = (Benchmarks) request.getServletContext().getAttribute(BenchmarkFilter.BENCHMARK_DATA);
                if (benchmarks == null) {
            %>
            <h4>
                <span class="outputStub notification">Нет результатов</span>
            </h4>
            <% } else { %>
            <table id='generateTable'>
                <tr>
                    <th>Path</th>
                    <th>Time</th>
                </tr>
                <%
                    Map<String, Long> tableMap = benchmarks.getBenchmarks();
                    for (String path : tableMap.keySet()) {
                %>
                <tr>
                    <td><%= path %></td>
                    <td><%= tableMap.get(path) %></td>
                </tr>
                <% } %>
            </table>
            <% } %>
        </div>
    </div>
</div>
</body>
</html>
