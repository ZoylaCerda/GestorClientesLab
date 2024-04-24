<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado de Candidatos</title>
</head>
<body>
<h1>Listad de candidatos 😐</h1>
<ul>
    <c:forEach items="${clientes}" var="cliente">
        <li>${cliente.nombre}  ${cliente.apellido}</li>
    </c:forEach>
</ul>
</body>
</html>