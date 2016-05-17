<%--
  Created by IntelliJ IDEA.
  User: sbt-yablokov-mv
  Date: 16.05.2016
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" uri="http://firstUsingTags" %>

<html>
<head>
    <title>JSP 2.0 Expression Language - Composite Expressions</title>
</head>
<body>
<h1>JSP 2.0 Expression Language - Composite Expressions</h1>
<hr>
This example illustrates EL composite expressions. Composite expressions
are formed by grouping together multiple EL expressions. Each of them is
evaluated from left to right, coerced to String, all those strings are
concatenated, and the result is coerced to the expected type.

<jsp:useBean id="beanValues" class="servlets.with_jsp.CompositeExpressions_BeanValues" />

<blockquote>
    <code>
        <table border="1">
            <thead>
            <td><b>EL Expression</b></td>
            <td><b>Type</b></td>
            <td><b>Result</b></td>
            </thead>
            <tr>
                <td>\${'hello'} wo\${'rld'}</td>
                <td>String</td>
                <td><jsp:setProperty name="beanValues" property="stringValue" value="${'hello'} wo${'rld'}"/>${beanValues.stringValue}</td>
            </tr>
            <tr>
                <td>\${'hello'} wo\${'rld'}</td>
                <td>String</td>
                <td><my:tagValues string="${'hello'} wo${'rld'}"/></td>
            </tr>
            <tr>
                <td>\${1+2}.\${220}</td>
                <td>Double</td>
                <td><jsp:setProperty name="beanValues" property="doubleValue" value="${1+2}.${220}"/>${beanValues.doubleValue}</td>
            </tr>
            <tr>
                <td>\${1+2}.\${220}</td>
                <td>Double</td>
                <td><my:tagValues double="${1+2}.${220}"/></td>
            </tr>
            <tr>
                <td>000\${1}\${7}</td>
                <td>Long</td>
                <td><jsp:setProperty name="beanValues" property="longValue" value="000${1}${7}"/>${beanValues.longValue}</td>
            </tr>
            <tr>
                <td>000\${1}\${7}</td>
                <td>Long</td>
                <td><my:tagValues long="000${1}${7}"/></td>
            </tr>
            <!--
               Undefined beanValues are to be coerced to String, to be "",
               https://bz.apache.org/bugzilla/show_bug.cgi?id=47413
             -->
            <tr>
                <td>\${undefinedFoo}hello world\${undefinedBar}</td>
                <td>String</td>
                <td><jsp:setProperty name="beanValues" property="stringValue" value="${undefinedFoo}hello world${undefinedBar}"/>${beanValues.stringValue}</td>
            </tr>
            <tr>
                <td>\${undefinedFoo}hello world\${undefinedBar}</td>
                <td>String</td>
                <td><my:tagValues string="${undefinedFoo}hello world${undefinedBar}"/></td>
            </tr>
            <tr>
                <td>\${undefinedFoo}\${undefinedBar}</td>
                <td>Double</td>
                <td><jsp:setProperty name="beanValues" property="doubleValue" value="${undefinedFoo}${undefinedBar}"/>${beanValues.doubleValue}</td>
            </tr>
            <tr>
                <td>\${undefinedFoo}\${undefinedBar}</td>
                <td>Double</td>
                <td><my:tagValues double="${undefinedFoo}${undefinedBar}"/></td>
            </tr>
            <tr>
                <td>\${undefinedFoo}\${undefinedBar}</td>
                <td>Long</td>
                <td><jsp:setProperty name="beanValues" property="longValue" value="${undefinedFoo}${undefinedBar}"/>${beanValues.longValue}</td>
            </tr>
            <tr>
                <td>\${undefinedFoo}\${undefinedBar}</td>
                <td>Long</td>
                <td><my:tagValues long="${undefinedFoo}${undefinedBar}"/></td>
            </tr>
        </table>
    </code>
</blockquote>
</body>
</html>