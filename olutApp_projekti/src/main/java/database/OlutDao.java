package database;

import java.util.List;

import model.Olut;


	/**
	 * Olut-tietokohteen käsittelypalvelut:
		 * findAll() - hae kaikki Oluet tietokannasta
		 * findById() - todo: hae yhden Oluen tiedot annetulla Olutid:llä
		 * addOlut() - todo: lisää Olut tietokantaan
		 * updateOlut() - todo: päivitä Oluen tiedot tietokantaan
		 * removeOlut() -  todo: poista Oluen tiedot tietokannasta
	 *
	 */

	public interface OlutDao {

		public List<Olut> findAll(); //Etsii ja listaa kaikki oluet
		
		public List<Olut> sortAll(); //Listaa kaikki oluet aakkosjärjestyksessä
		
		public boolean addOlut(Olut olut); //Lisää oluen
		
		public boolean removeOlut(int olut_id); //Poistaa oluen
		
		public boolean editOlut(Olut olut); //Muokkaa oluen
		
		public List<Olut> findOlut(String nimi); //Etsii oluen/oluet nimen perusteella
		
		public Olut muutaOlut(int olut_id); //Luo olut olion id numeron perusteella
	}