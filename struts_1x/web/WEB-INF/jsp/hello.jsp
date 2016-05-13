<%--
  Created by IntelliJ IDEA.
  User: sbt-yablokov-mv
  Date: 13.05.2016
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HelloWorld through JSP</title>
</head>
<body>
    <h1>
        <%
        String myName = request.getParameter("myName");
        if (myName == null || myName.isEmpty()) {
        %>
            Hello, JSP!
        <% } else { %>
            Hello, JSP! I'm <%= myName%>
        <% } %>
    </h1>
</body>
</html>
