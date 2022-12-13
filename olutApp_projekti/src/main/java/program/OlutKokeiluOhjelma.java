package program;

import java.util.List;

import database.OlutDao;
import database.OlutJdbcDao;
import model.Olut;

public class OlutKokeiluOhjelma {

	public static void main(String[] args) {
		
		OlutDao olutdao = new OlutJdbcDao();
		
		List<Olut> oluet = olutdao.findAll();
		 for (Olut olut : oluet) {
			 System.out.println(olut.getNimi());
			 System.out.println(olut.getMaa());
		 }
		
	}
}