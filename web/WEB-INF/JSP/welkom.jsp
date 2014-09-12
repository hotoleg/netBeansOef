<%-- Een welkom pagina --%> 
<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.PrintWriter"%> 
<%@page import="java.util.Calendar"%>
<!doctype html> 
<html lang="nl">
    <head>
        <title>Pizza Luigi</title>
        <link rel="stylesheet" href="styles/default.css" />
    </head>
    <body>
        <c:import url="/WEB-INF/JSP/menu.jsp"/>
        <h1>Welkom bij Pizza Luigi</h1>
        <img src="images/luigi.png" alt="Luigi"/>
        <h1>${boodschap}</h1>
        <h2>De zaakvoerder</h2>
        <dl>
            <dt>Naam:</dt><dd>${zaakvoerder.naam}</dd>
            <dt>Aantal kinderen:</dt><dd>${zaakvoerder.aantalKinderen}</dd>
            <dt>Gehuwd:</dt><dd>${zaakvoerder.gehuwd ? 'Ja' : 'Nee' }</dd>
            <dt>Adres:</dt>
            <dd>${zaakvoerder.adres.straat} ${zaakvoerder.adres.huisNr}
            ${zaakvoerder.adres.postCode} ${zaakvoerder.adres.gemeente}</dd>
        </dl>
        <div>Deze pagina werd ${aantalKeerBekeken} keer bekeken.</div>
        <c:import url="/WEB-INF/JSP/about.jsp"/>
    </body>
</html>
