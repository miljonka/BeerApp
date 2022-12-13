package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.OlutDao;
import database.OlutJdbcDao;
import model.Olut;


@WebServlet("/muuta-olut") //Muuta painike hakee id numerolla oluen tiedot ja lähettää ne eteenpäin muokkauslomakkeelle
public class MuutaServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	try {
		// Hakee ja lähettää id numerolla olevan olion eteenpäin oluenmuokkauslomakkeelle
		String idStr = request.getParameter("olut_id");
		int id = Integer.parseInt(idStr);
		OlutDao olutdao = new OlutJdbcDao();
		Olut olut = olutdao.muutaOlut(id); //Luodaan olut olio sen id:n perusteella
		
		request.setAttribute("olut", olut); //olut lähtee oluenmuokkauslomakkeelle
		request.getRequestDispatcher("/WEB-INF/oluenmuokkauslomake.jsp").forward(request, response);
		
			
	
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("viesti", "Sovelluksessa tapahtui virhe");
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}
	
	}
}
