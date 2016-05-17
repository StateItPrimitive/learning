<%@ page import="struts.beans.LookupForm" %><%--
  Created by IntelliJ IDEA.
  User: sbt-yablokov-mv
  Date: 16.05.2016
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Struts Example Page</title>
</head>
<body>
    <table>
        <tr>
            <td>Cleint name:</td>
            <td>
                <% pageContext.setAttribute("lookupForm", new LookupForm()); %>
                <bean:write name="lookupForm" property="clientFio" />
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td>Cleint accounts:</td>--%>
            <%--<td><bean:write name="lookupForm" property="clientName" /></td>--%>
        <%--</tr>--%>
    </table>
</body>
</html>
