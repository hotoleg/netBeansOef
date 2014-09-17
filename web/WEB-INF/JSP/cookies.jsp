<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!doctype html>
<html lang="nl">
    <head>
        <title>Pizza Luigi - cookies</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp" />
        <h1>Cookie voorbeeld</h1>
        <c:url value="/cookies.htm" var="action"/>
        <form method="post" action="${action}">
            <label>Naam: <input name="naam" value="${naam}"/></label>
            <input type="submit" value="Onthoud me"/>
        </form>
    </body>
</html>