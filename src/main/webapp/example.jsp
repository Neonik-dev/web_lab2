<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%--<html>--%>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--</body>--%>
<%--</html>--%>
<%! private static final String DEFAULT_NAME = "World";%>
<html>
<head>
    <title>Hello JavaServer Page</title>
</head>
<%-- Determine the specified name (or use default) --%>
<%
    String name = request.getParameter("name");
    if ( (name == null) || (name.length() == 0) ) {
        name = DEFAULT_NAME;
    }
%>
<body>
<b>Hello, <%= name %></b>
</body>
</html>