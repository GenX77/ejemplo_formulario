<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ejemplo Formulario Servlet</title>
    <link rel="stylesheet" type="text/css" href="./styles.css">
</head>
<body>
    <div>
        <h3>Ejemplo Formulario Servlet</h3>
        <form action="miServlet" method="post">
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="${nombre}"><br><br>
            <input type="submit" value="Enviar">
        </form>

        <!-- Muestra el nombre si ha sido ingresado -->
        <c:if test="${not empty nombre}">
            <p>Bienvenida ${nombre}!</p>
        </c:if>
    </div>
</body>
</html>