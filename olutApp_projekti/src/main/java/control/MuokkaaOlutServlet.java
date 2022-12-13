package control;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.OlutDao;
import database.OlutJdbcDao;

import model.Olut;


@WebServlet("/muokkaa-olut") //Muokkauslomake
public class MuokkaaOlutServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		request.getRequestDispatcher("/WEB-INF/oluenmuokkauslomake.jsp").forward(request, response);
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {
		
	try {

		//Muokataan olemassa olevan oluen tietoja
		String nimi = request.getParameter("nimi");
		String maa = request.getParameter("maa");
		String tyyppi = request.getParameter("tyyppi");
		String prosentitStr = request.getParameter("prosentit");
		String arvosanaStr = request.getParameter("arvosana");
		
		// Teksti numeroiksi
		double prosentit = Double.parseDouble(prosentitStr);
		double arvosana = Double.parseDouble(arvosanaStr);
		
		// Id saadaan MuutaServletistä, joka määrittää mitä olutta muokataan
		String olut_id = request.getParameter("olut_id");
		int id = Integer.parseInt(olut_id);
		//Päivitetään olio
		Olut olut = new Olut(id, nimi, maa, tyyppi, prosentit, arvosana);
		System.out.println("Olut: " + olut.toString());
		
		OlutDao olutdao = new OlutJdbcDao();
		
		boolean muokkausOnnistui = olutdao.editOlut(olut);
		
		if(muokkausOnnistui)
			
			response.sendRedirect("/listaa-oluet");
		else {
			request.setAttribute("viesti", "oluen lisäyksessä tietokantaan tapahtui virhe!");
			request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
		}

	} catch (NumberFormatException e) {
		
		e.printStackTrace();  // tulostetaan Consoleen virhetilanteessa metodikutsupinoa, josta näkee rivinumeron, jossa Exception tapahtuu

		request.setAttribute("viesti", "Olut-lomakkeella syötetyt tiedot eivät olleet kelvolliset.");
		// servlet kutsuu jsp:tä
		request.getRequestDispatcher("/WEB-INF/tapahtumaraportti.jsp").forward(request, response);
	
}
}
}