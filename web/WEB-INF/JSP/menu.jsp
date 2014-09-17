<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
    <img src="${pageContext.servletContext.contextPath}/images/pizzaluigilogo.png"alt="logo"/>
<div class="wrapper">
<div class="container"><ul class="menu" rel="sam1">
<c:url value="/" var="rootURL"/>
<li><a href="${rootURL}" class="m">Welkom</a></li>
<c:url value="/menu/pizzas.htm" var="pizzasURL"/>
<li><a href="${pizzasURL}" class="m">Pizza's</a></li>
<c:url value="/statistieken.htm" var="statistiekURL"/>
<li><a href="${statistiekURL}" class="m">Statistieken</a></li>
<c:url value="/pizzas/tussenprijzen.htm" var="pizzasTussenPrijzenURL"/>
<li><a href="${pizzasTussenPrijzenURL}" class="m">Pizza’s tussen prijzen</a></li>
<c:url value="/pizzas/voorkeuren.htm" var="voorkeurpizzasURL"/>
<li><a href="${voorkeurpizzasURL}">Voorkeurpizza's</a></li>
<c:url value="/pizzas/pizzatoevoegen.htm" var="pizzatoevoegenURL"/>
<li><a href="${pizzatoevoegenURL}">Pizza toevoegen</a></li>
<c:url value="/cookies.htm" var="cookiesURL"/>
<li><a href="${cookiesURL}">Cookies</a></li>
<c:url value="/headers.htm" var="headersURL"/>
<li><a href="${headersURL}">Headers</a></li>
<c:url value="/pizzas/pizzasbestellen.htm" var="bestelURL"/>
<li><a href="${bestelURL}">Bestellen</a></li>
</ul>
</div>
</div>
</header>

