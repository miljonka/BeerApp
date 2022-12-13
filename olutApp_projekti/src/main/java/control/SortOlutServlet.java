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

@WebServlet("/listaa-oluet-sorted")   // Listaa kaikki oluet aakkojärjestyksessä 
public class SortOlutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//Haetaan kaikki oluet tietokannasta
		OlutDao olutdao = new OlutJdbcDao();
		List<Olut> oluet = olutdao.sortAll();
		request.setAttribute("oluet", oluet);
		
		request.getRequestDispatcher("/WEB-INF/oluet.jsp").forward(request, response);
		
}
}