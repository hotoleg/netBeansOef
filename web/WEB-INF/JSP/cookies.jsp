<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:if test="${not empty sessionScope.locale}">
    <fmt:setLocale value="${sessionScope.locale}"/> 
</c:if>
<fmt:setBundle basename='resourceBundles.teksten'/>
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
        <c:if test="${not empty naam}">
            <div>
                <fmt:message key="jeNaamBestaatUitLetters">
                    <fmt:param value="${naam.length()}"/> 
                </fmt:message>
            </div>
        </c:if>
        <div>
            <c:url value="/cookies.htm" var="nlBEURL">
                <c:param name="locale" value="nl-BE" />
            </c:url>
            <c:url value="/cookies.htm" var="enUSURL">
                <c:param name="locale" value="en-US" />
            </c:url>
            <a href="${nlBEURL}">Ik spreek Nederlands en woon in België</a>
            <a href="${enUSURL}">I speak English and live in the USA</a>
        </div>
    </body>
</html>