package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.OlutDao;
import database.OlutJdbcDao;

import model.Olut;


@WebServlet("/lisaa-uusiolut") //Lisää uusiolut
public class UusiOlutLisaaServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/oluenlisayslomake.jsp").forward(request, response);  //pyydetään lisäyslomaketta
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		
	try {
		//Luodaan uusi olutolio lomakkeen avulla
		String nimi = request.getParameter("nimi");
		String maa = request.getParameter("maa");
		String tyyppi = request.getParameter("tyyppi");
		String prosentitStr = request.getParameter("prosentit");
		String arvosanaStr = request.getParameter("arvosana");
		
		//Stringit numeroiksi
		double prosentit = Double.parseDouble(prosentitStr);
		double arvosana = Double.parseDouble(arvosanaStr);
		
		//luodaan uus olut olio
		Olut olut = new Olut(nimi, maa, tyyppi, prosentit, arvosana);
		System.out.println("Olut: " + olut.toString());
		
		OlutDao olutdao = new OlutJdbcDao();
		
		boolean lisaysOnnistui = olutdao.addOlut(olut); //lisätään olut listaan
		if(lisaysOnnistui)
			response.sendRedirect("/listaa-oluet");
		else {
			request.setAttribute("viesti", "oluen lisäyksessä tietokantaan tapahtui virhe!");
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}

	} catch (NumberFormatException e) {
		
		e.printStackTrace();  // tulostetaan Consoleen virhetilanteessa metodikutsupinoa, josta näkee rivinumeron, jossa Exception tapahtuu
		PrintWriter viesti = response.getWriter();
		
		viesti.println("<script type=\"text/javascript\">");
		viesti.println("alert('nope');");
		viesti.println("</script>");
		request.setAttribute("viesti", "Sovelluksessa tapahtui virhe");
		request.setAttribute("viesti", "Olut-lomakkeella syötetyt tiedot eivät olleet kelvolliset.");
		// servlet kutsuu jsp:tä
	
		request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
	
}
}
}
