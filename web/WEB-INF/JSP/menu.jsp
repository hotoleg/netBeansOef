<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
<div class="wrapper">
<div class="container"><ul class="menu" rel="sam1">
        <c:url value="/" var="rootURL"/>
<li><a href="${rootURL}" class="m">Welkom</a></li>
<c:url value="/sausen" var="sausenURL"/>
<li><a href="${sausenURL}" class="m">Sausen</a></li>
</ul>
</div>
</div>
</header>
