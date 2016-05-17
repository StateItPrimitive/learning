<%--
  Created by IntelliJ IDEA.
  User: sbt-yablokov-mv
  Date: 16.05.2016
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://firstUsingTags" prefix="myTag" %>

<html>
<head>
    <title>JSP 2.0 Expression Language - Functions</title>
</head>
<body>
<h1>JSP 2.0 Expression Language - Functions</h1>
<hr>
An upgrade from the JSTL expression language, the JSP 2.0 EL also
allows for simple function invocation.  Functions are defined
by tag libraries and are implemented by a Java programmer as
static methods.

<blockquote>
    <b>Change Parameter</b>
    <form action="function.jsp" method="GET">
        parmName = <input type="text" name="parmName" value="${param["parmName"]}">
        <input type="submit">
    </form>
    <br>
    <code>
        <table border="1">
            <thead>
            <td><b>EL Expression</b></td>
            <td><b>Result</b></td>
            </thead>
            <tr>
                <td>\${param["parmName"]}</td>
                <td>${param["parmName"]}&nbsp;</td>
            </tr>
            <tr>
                <td>\${myTag:reverse(param["parmName"])}</td>
                <td>${myTag:reverse(param["parmName"])}&nbsp;</td>
            </tr>
            <tr>
                <td>\${myTag:reverse(my:reverse(param["parmName"]))}</td>
                <td>${myTag:reverse(myTag:reverse(param["parmName"]))}&nbsp;</td>
            </tr>
            <tr>
                <td>\${myTag:countVowels(param["parmName"])}</td>
                <td>${myTag:countVowels(param["parmName"])}&nbsp;</td>
            </tr>
        </table>
    </code>
</blockquote>
</body>
</html>