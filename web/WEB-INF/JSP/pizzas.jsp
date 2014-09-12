<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizza Luigi - pizza's</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    <body>
        <h1>Onze pizza's
            
        </h1> 
        <c:forEach begin="1" end="${sterren}">
            <img src="${contextPath}/images/ster.png" alt="ster"/>
        </c:forEach>
        <ul>
        <c:forEach var="pizza" items="${pizzas}"> 
            <li><li>${pizza.naam} ${pizza.prijs}&euro;</li></li> 
        </c:forEach> 
        <li><br /><br /><br /></li>
        <c:forEach var="entry" items="${pizzas1}" varStatus="status">
            <li class="${status.count % 2 == 0 ? 'even' : 'oneven'}">
                ${entry.key}: <c:out value="${entry.value.naam}"/> ${entry.value.prijs}&euro;
                ${entry.value.pikant ? "pikant" : "niet pikant"}
                <c:url value="/pizzas/detail" var="detailURL">
                <c:param name="nummer" value="${entry.key}"/>
                <c:param name="naam" value="${entry.value.naam}"/>
                </c:url>
                <a href="<c:out value='${detailURL}'/>">Detail</a>
            </li>
        </c:forEach>
        </ul>
            
    </body>
</html>
