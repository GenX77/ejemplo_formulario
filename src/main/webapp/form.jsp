<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ejemplo Formulario Servlet</title>
    <link rel="stylesheet" type="text/css" href="./styles.css">
    <script>
        // Función para actualizar el reloj
        function actualizarReloj() {
            var now = new Date();
            var fecha = now.toLocaleDateString();
            var hora = now.toLocaleTimeString();
            document.getElementById('reloj').textContent = fecha + ' ' + hora;
        }

        // Llama a actualizarReloj cada segundo
        setInterval(actualizarReloj, 1000);

        // Actualiza el reloj inmediatamente cuando se carga la página
        window.onload = actualizarReloj;
    </script>
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
            <p>Hola, ${nombre}!</p>
        </c:if>

        <!-- Mostrar el reloj -->
        <div id="reloj"></div>
    </div>
</body>
</html>