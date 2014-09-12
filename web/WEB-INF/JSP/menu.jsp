<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
<img src="${pageContext.servletContext.contextPath}/images/pizzaluigilogo.png"
alt="logo"/>
<nav>
<ul class="menu">
<c:url value="/" var="rootURL"/>
<li><a href="${rootURL}">Welkom</a></li>
<c:url value="/pizzas" var="pizzasURL"/>
<li><a href="${pizzasURL}">Pizza's</a></li>
<c:url value="/statistieken" var="statistiekURL"/>
<li><a href="${statistiekURL}">Statistieken</a></li>
</ul>
</nav>
</header>
