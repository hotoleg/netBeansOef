<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
    <img src="${pageContext.servletContext.contextPath}/images/pizzaluigilogo.png"alt="logo"/>
<div class="wrapper">
<div class="container"><ul class="menu" rel="sam1">
<c:url value="/" var="rootURL"/>
<li><a href="${rootURL}" class="m">Welkom</a></li>
<c:url value="/pizzas" var="pizzasURL"/>
<li><a href="${pizzasURL}" class="m">Pizza's</a></li>
<c:url value="/statistieken" var="statistiekURL"/>
<li><a href="${statistiekURL}" class="m">Statistieken</a></li>
<c:url value="tussenprijzen" var="pizzasTussenPrijzenURL"/>
<li><a href="${pizzasTussenPrijzenURL}" class="m">Pizza’s tussen prijzen</a></li>
<c:url value="voorkeuren" var="voorkeurpizzasURL"/>
<li><a href="${voorkeurpizzasURL}">Voorkeurpizza's</a></li>
<c:url value="pizzatoevoegen" var="pizzatoevoegenURL"/>
<li><a href="${pizzatoevoegenURL}">Pizza toevoegen</a></li>
<c:url value="/cookies" var="cookiesURL"/>
<li><a href="${cookiesURL}">Cookies</a></li>
<c:url value="/headers" var="headersURL"/>
<li><a href="${headersURL}">Headers</a></li>
<c:url value="/pizzasbestellen" var="bestelURL"/>
<li><a href="${bestelURL}">Bestellen</a></li>
</ul>
</div>
</div>
</header>

