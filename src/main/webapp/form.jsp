<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Formulario</title>
</head>
<body>
    <h2>Ingresar Nombre</h2>
    <form action="miServlet" method="post">
        Nombre: <input type="text" name="nombre">
        <input type="submit" value="Enviar">
    </form>

    <c:if test="${not empty nombre}">
        <h3>Bienvenido: ${nombre}</h3>
    </c:if>
</body>
</html>