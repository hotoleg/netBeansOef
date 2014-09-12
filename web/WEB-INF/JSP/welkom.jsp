<%@ page contentType="text/html" pageEncoding="UTF-8" session="false"%> 
<%@page import="java.io.PrintWriter"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Calendar"%>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Frituur Frida</title>
        <link rel="stylesheet" href="styles/default.css" />
    </head>
    <body>
        <img class="midden" src="${afbeelding}" />
        <h1>Frituur Frida</h1>
        <img class="midden" src="images/frituurfrida.png" alt="Frida"/>
        <h2>De zaakvoerder</h2>
            <p>Straat:${adres.straat}<br />
            Huisnummer:${adres.huisNr}<br />
            Gemeente:${adres.gemeente.gemeente}<br />
            Postcode:${adres.gemeente.postCode}<br /></p>
        
    </body>
</html>
