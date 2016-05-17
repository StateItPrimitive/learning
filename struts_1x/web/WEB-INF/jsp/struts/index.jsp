<%--
  Created by IntelliJ IDEA.
  User: sbt-yablokov-mv
  Date: 16.05.2016
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Struts Example Page</title>
    </head>
</head>
<body>
    <html:errors />
    <html:form action="/lookup">
        <table>
            <tr>
                <td>Symbol:</td>
                <td><html:text property="clientId" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><html:submit /></td>
            </tr>
        </table>
    </html:form>
</body>
</html>