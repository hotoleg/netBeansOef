<%-- 
    Document   : copyright
    Created on : 19-sep-2014, 14:35:58
    Author     : oleg.kolokolnikov
--%>


<%@ tag description="copyright tonen" pageEncoding="UTF-8"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="resourceBundles.teksten" />
<div>
<fmt:message key="copyright" />
<a href="mailto:joske_vermeulen@fastmail.fm">Joske een mail sturen</a>
</div>
<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>