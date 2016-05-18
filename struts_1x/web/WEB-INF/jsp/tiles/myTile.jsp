<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<link rel="stylesheet" type="text/css" href="css/tiles.css" />
<html>
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Struts Example Page</title>
    </head>
</head>
<body>
    <div class="header">
        <tiles:insert attribute="header" />
    </div>
    <div class="body">
        <tiles:insert attribute="body" />
    </div>
    <div class="footer">
        <tiles:insert attribute="footer" />
    </div>
</body>
</html>