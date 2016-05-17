<%--
  Created by IntelliJ IDEA.
  User: sbt-yablokov-mv
  Date: 16.05.2016
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="myTag" uri="http://firstUsingTags" %>

<html>
<head>
    <title>JSP 2.0 Examples - Repeat SimpleTag Handler</title>
</head>
<body>
    <h1>JSP 2.0 Examples - Repeat SimpleTag Handler</h1>
    <hr>
    <p>This tag handler accepts a "num" parameter and repeats the body of the
        tag "num" times.  It's a simple example, but the implementation of
        such a tag in JSP 2.0 is substantially simpler than the equivalent
        JSP 1.2-style classic tag handler.</p>
    <p>The body of the tag is encapsulated in a "JSP Fragment" and passed
        to the tag handler, which then executes it five times, inside a
        for loop.  The tag handler passes in the current invocation in a
        scoped variable called count, which can be accessed using the EL.</p>
    <br>
    <b>Result:</b><br>
    <myTag:repeat num="5">
        Invocation ${count} of 5<br>
    </myTag:repeat>
</body>
</html>