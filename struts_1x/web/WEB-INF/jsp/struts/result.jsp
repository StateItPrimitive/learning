<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<tiles:insert definition="base.definition">
    <tiles:put type="string" name="header" value="Header realize" />
    <tiles:put type="string" name="body">
        <table>
            <tr>
                <%--<% LookupForm lookupForm = (LookupForm)TagUtils.getInstance().lookup(pageContext, Constants.BEAN_KEY, null);%>--%>
                <td>Client name:</td>
                <td><bean:write name="lookupForm" property="clientFio"/></td>
            </tr>
        </table>
    </tiles:put>
    <tiles:put type="string" name="footer" value="Footer realize"/>
</tiles:insert>