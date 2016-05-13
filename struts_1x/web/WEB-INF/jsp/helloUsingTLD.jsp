<%--
  Created by IntelliJ IDEA.
  User: sbt-yablokov-mv
  Date: 13.05.2016
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://firstUsingTags.com" prefix="myTag" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>
        <myTag:helloJSP myName='<%= request.getParameter("myName") %>' />
    </h1>
</body>
</html>
