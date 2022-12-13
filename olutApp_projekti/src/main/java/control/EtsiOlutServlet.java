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


@WebServlet("/etsi-olut") // Hakupalkki
public class EtsiOlutServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response)

				throws ServletException, IOException {
	
			
	try {
		//Hakupalkin syöttäkenttä pyytää oluen nimeä ja muuttaa syötetyn nimen pienellä kirjoitetuksi
		String nimi1 = request.getParameter("olutNimi");
		String nimi = nimi1.toLowerCase();
		
		//Hetaan syötetyt nimet tietokannasta
		OlutDao olutdao = new OlutJdbcDao();
		List<Olut> oluet_loytyi = olutdao.findOlut(nimi);
		
		//Lähetetään tiedot eteenpäin
		request.setAttribute("oluet_loytyi", oluet_loytyi);
		request.getRequestDispatcher("/WEB-INF/oluet.jsp").forward(request, response);
		
		
} catch (Exception e) {
	e.printStackTrace();
	request.setAttribute("viesti", "Sovelluksessa tapahtui virhe");
	request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
}

}
}
