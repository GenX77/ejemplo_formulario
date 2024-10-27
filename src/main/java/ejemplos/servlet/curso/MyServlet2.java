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
import java.util.Locale;

@WebServlet(urlPatterns = "/myServlet2")
public class MyServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String nombre = request.getParameter("nombre");
		String fechaHoraActual = request.getParameter("fechaHoraActual");

		// Parsear la fecha y hora actual para obtener más detalles
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraActual, formato);

		// Obtener el día de la semana
		String diaSemana = fechaHora.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, new Locale("es", "ES"));

		// Determinar si es de día, tarde o noche
		int hora = fechaHora.getHour();
		String momentoDelDia;
		if (hora >= 6 && hora < 12) {
			momentoDelDia = "mañana";
		} else if (hora >= 12 && hora < 18) {
			momentoDelDia = "tarde";
		} else {
			momentoDelDia = "noche";
		}

		// Enviar página HTML al cliente
		out.println("<html>");
		out.println("<head><title>Bienvenida</title></head>");
		out.println("<body>");
		out.println("<h1>Bienvenida " + nombre + "!</h1>");
		//out.println("<p>Fecha y hora actual: " + fechaHoraActual + "</p>");
		out.println("<h1><p>Hoy es " + diaSemana + " y es de " + momentoDelDia + ".</p></h1>");
		out.println("</body></html>");
	}
}
