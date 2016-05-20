<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="lookupForm" class="struts.beans.LookupForm" scope="request"/>

<tiles:insert definition="base.definition">
    <tiles:put type="string" name="header" value="Header realize" />
    <tiles:put type="string" name="body">
        <%--<% LookupForm lookupForm = (LookupForm)TagUtils.getInstance().lookup(pageContext, Constants.BEAN_KEY, null);%>--%>
        <table>
            <tr>
                <th>Client name:</th>
                <th>Client accounts:</th>
            </tr>
            <tr>
                <td><bean:write name="lookupForm" property="clientFio"/></td>
                <td>
                    <%--first way--%>
                    <%--<bean:define id="clientAccountsList" name="lookupForm" property="clientAccounts" type="java.util.List<Long>"/>--%>
                    <%--<% for (Long clientAccount: lookupForm.getClientAccounts()) {--%>
                        <%--out.println(clientAccount + "<br/>");--%>
                    <%--} %>--%>

                    <%--second way--%>
                    <c:forEach items="${lookupForm.clientAccounts}" var="clientAccount2">
                        <c:out value="${clientAccount2}" /><br/>
                    </c:forEach>
                </td>
            </tr>
        </table>
    </tiles:put>
    <tiles:put type="string" name="footer" value="Footer realize"/>
</tiles:insert>