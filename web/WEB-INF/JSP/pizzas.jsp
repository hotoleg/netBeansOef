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
        <h1>Onze pizza's</h1> 
        <c:forEach begin="1" end="${sterren}">
            <img src="${contextPath}/images/ster.png" alt="ster"/>
        </c:forEach>
        <ul>
            <c:forEach var="pizza" items="${pizzas}" varStatus="status">
        <li class="${status.count % 2 == 0 ? 'even':'oneven'}">${pizza.nummer}:
        <c:out value="${pizza.naam}"/> ${pizza.prijs}&euro;
        ${pizza.pikant ? "pikant" : "niet pikant"}
        <c:url value="/pizzas/pizzadetail.htm" var="detailURL">
        <c:param name="nummer" value="${pizza.nummer}"/>
        </c:url>
        <a href="<c:out value='${detailURL}'/>">Detail</a>
        <c:if test="${pizzaNummersMetFoto.contains(pizza.nummer)}">
            <c:url value="/pizzafotos/${pizza.nummer}.jpg" var="fotoURL"/>
            <a href="${fotoURL}">Foto</a>
        </c:if>
        </li>
        </c:forEach>
        </ul>
    </body>
</html>
