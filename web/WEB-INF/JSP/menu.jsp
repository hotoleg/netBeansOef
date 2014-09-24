<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty sessionScope.locale}">
    <fmt:setLocale value="${sessionScope.locale}"/> 
</c:if>
<fmt:setBundle basename='resourceBundles.text'/>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="styles/menu.css" />
<title>menu</title>
</head>
<body>
   
   

<div class="drop">
<ul class="drop_menu">
<li><a href='#'><fmt:message key="home"/></a>
	<ul>
	<li><a href='#'>Sub Link 1</a></li>
	<li><a href='#'>Sub Link 2</a></li>
	</ul>
</li>
<li><a href='#'><fmt:message key="article"/></a>
	<ul>
	<li><a href='#'>Sub Link 1</a></li>
	<li><a href='#'>Sub Link 2</a></li>
	<li><a href='#'>Sub Link 3</a></li>
	<li><a href='#'>Sub Link 4</a></li>
	</ul>
</li>
<li><a href='#'><fmt:message key="about"/></a>
</li>
    <li><a href='#'><fmt:message key="language"/></a>
	<ul>
	<li><c:url value="/cookies.htm" var="nlBEURL">
                <c:param name="locale" value="nl-BE" />
            </c:url>
            <a href='${nlBEURL}'>Nederlands</a></li>
	<li>
            <c:url value="/cookies.htm" var="enUSURL">
                <c:param name="locale" value="en-US" />
            </c:url>
            <a href='${enUSURL}'>English</a></li>
	<li>
            <c:url value="/cookies.htm" var="ruRUURL">
                <c:param name="locale" value="ru-RU" />
            </c:url>
            <a href='${ruRUURL}'>Русский</a></li>
	<li><a href='#'>Sub Link 4</a></li>
	</ul>
</li>
</ul>
    
</div>
</body>
</html>