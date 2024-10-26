package ejemplos.servlet.curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Obtener la fecha y hora actual
		LocalDateTime ahora = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String fechaHoraActual = ahora.format(formato);

		// Enviar página HTML al cliente
		out.println("<html>");
		out.println("<head><title>Ejemplo formulario desde Servlet</title></head>");
		out.println("<body>");
		out.println("<h1>Ejemplo formulario</h1>");

		// Formulario con campo nombre con valor por defecto "Marta"
		out.println("<form method='POST' action='/myServlet'>");
		out.println(" <label for='nombre'>Nombre:</label>");
		out.println(" <input type='text' id='nombre' name='nombre' value='Marta'>");
		out.println(" <input type='submit' value='Enviar'>");
		out.println("</form>");


		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");

		// Obtener la fecha y hora actual
		LocalDateTime ahora = LocalDateTime.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String fechaHoraActual = ahora.format(formato);

		// Redirigir a MyServlet2 con los parámetros
		response.sendRedirect("/myServlet2?nombre=" + nombre + "&fechaHoraActual=" + fechaHoraActual);
	}
}