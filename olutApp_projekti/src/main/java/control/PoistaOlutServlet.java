package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.OlutDao;
import database.OlutJdbcDao;


@WebServlet("/poista-olut") //Poistaa oluen sen id numerolla
public class PoistaOlutServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	
	try {
		//Poistaa oluen tietokannasta sen id numerolla 
		String idStr = request.getParameter("olut_id");
		int id = Integer.parseInt(idStr);
		OlutDao olutdao = new OlutJdbcDao();
		boolean poistoOnnistui = olutdao.removeOlut(id);
		if (poistoOnnistui) {
			response.sendRedirect("/listaa-oluet");
		} else {
			request.setAttribute("viesti", "Oluen poistossa tapahtui virhe");
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("viesti", "Sovelluksessa tapahtui virhe");
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}
	
	}
}
