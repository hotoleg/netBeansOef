<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sausen</title>
        <link rel="stylesheet" href="styles/default.css" />
    </head>
    <body>
        <h1>Sausen</h1>
        <c:forEach var="sausen" items="${sausen}"> 
            <h3>${sausen.naam}</h3>
            <img src="${contextPath}/images/${sausen.naam}.jpg" alt="${sausen.naam}"/>
            ingrediënten:
            <c:forEach var="ingredient" items="${sausen.ingredienten}"
            varStatus="status">
            ${ingredient}<c:if test="${not status.last}">, </c:if>
            </c:forEach>
        </c:forEach> 
    </body>
</html>
