package ejemplos.servlet.curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// send HTML page to client
		out.println("<html>");
		out.println("<head><title>Ejemplo HTML desde Servlet</title></head>");
		out.println("<body>");
		out.println("<h1>Ejemplo Servlet</h1>");
		out.println("<p>Este es un ejemplo en el curso de Java para generar HTML desde un Servlet.</p>");
		out.println("<p><a href=\"/myServlet2\">Vamos al otro Servlet</a></p>");

		// Formulario con campo nombre
		out.println("<form method='POST' action='/myServlet'>");
		out.println(" <label for='nombre'>Nombre:</label>");
		out.println(" <input type='text' id='nombre' name='nombre'>");
		out.println(" <input type='submit' value='Enviar'>");
		out.println("</form>");

		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String nombre = request.getParameter("nombre");

		// send HTML page to client
		out.println("<html>");
		out.println("<head><title>Respuesta del Formulario</title></head>");
		out.println("<body>");
		out.println("<h1>Hola " + nombre + "!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}