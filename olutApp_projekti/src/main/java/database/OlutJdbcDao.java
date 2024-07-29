package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Olut;

public class OlutJdbcDao implements OlutDao {

	//Etsi kaikki oluet tietokannasta
	public List<Olut> sortAll() {
		Connection dbyhteys = null;
		PreparedStatement sqlLause = null;
		ResultSet tulostaulu = null;
		List<Olut> oluet = new ArrayList<Olut>(); // tyhjä Olutlista
		Olut olut = null; // apuviittausmuuttuja uuden Olutolion luontiin

		try {
			dbyhteys = Database.getDBConnection();
			sqlLause = dbyhteys.prepareStatement(
					"SELECT olut_id, olutNimi, maa, olutTyyppi, olutProsentit, olutArvosana FROM oluet ORDER by olutNimi ASC;");
			tulostaulu = sqlLause.executeQuery();
			while (tulostaulu.next()) {
				// luodaan Olutrivin tiedoista Olut-luokan olion
				olut = createOlutObjectFromRow(tulostaulu);
				// lisätään Olutolio listaan
				oluet.add(olut);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(tulostaulu, sqlLause, dbyhteys);
		}

		return oluet; // palautetaan Olutlista
	}
	
	public List<Olut> findAll() {
		Connection dbyhteys = null;
		PreparedStatement sqlLause = null;
		ResultSet tulostaulu = null;
		List<Olut> oluet = new ArrayList<Olut>(); // tyhjä Olutlista
		Olut olut = null; // apuviittausmuuttuja uuden Olutolion luontiin

		try {
			dbyhteys = Database.getDBConnection();
			sqlLause = dbyhteys.prepareStatement(
					"SELECT olut_id, olutNimi, maa, olutTyyppi, olutProsentit, olutArvosana FROM oluet;");
			tulostaulu = sqlLause.executeQuery();
			while (tulostaulu.next()) {
				// luodaan Olutrivin tiedoista Olut-luokan olion
				olut = createOlutObjectFromRow(tulostaulu);
				// lisätään Olutolio listaan
				oluet.add(olut);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(tulostaulu, sqlLause, dbyhteys);
		}

		return oluet; // palautetaan Olutlista
	}

	private Olut createOlutObjectFromRow(ResultSet resultset) {
		try {
			// Haetaan yhden oluen tiedot kyselyn tulostaulun (ResultSet-tyyppinen
			// resultset-olion) aktiiviselta tietoriviltä
			int id = resultset.getInt("olut_id");
			String nimi = resultset.getString("olutNimi");
			String maa = resultset.getString("maa");
			String tyyppi = resultset.getString("olutTyyppi");
			double prosentit = resultset.getDouble("olutProsentit");
			double arvosana = resultset.getDouble("olutArvosana");

			// Luodaan ja palautetaan uusi Olut-luokan olio
			return new Olut(id, nimi, maa, tyyppi, prosentit, arvosana);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//Lisää olut
	public boolean addOlut(Olut olut) {
		Connection yhteys = null;
		PreparedStatement stmtInsert = null;
		boolean updateSuccess = false;

		try {
			yhteys = Database.getDBConnection();
			String sqlInsert = "INSERT INTO oluet (olutNimi, maa, olutTyyppi, olutProsentit, olutArvosana) VALUES (?, ?, ?, ?, ?)";
			stmtInsert = yhteys.prepareStatement(sqlInsert);
			stmtInsert.setString(1, olut.getNimi());
			stmtInsert.setString(2, olut.getmaa());
			stmtInsert.setString(3, olut.getTyyppi());
			stmtInsert.setDouble(4, olut.getProsentit());
			stmtInsert.setDouble(5, olut.getArvosana());

			int rowAffected = stmtInsert.executeUpdate();
			if (rowAffected == 1)
				updateSuccess = true;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(stmtInsert, yhteys);
		}
		return updateSuccess;
	}
	//Poista olut
	public boolean removeOlut(int olut_id) {
		Connection yhteys = null;
		PreparedStatement stmtDelete = null;
		boolean updateSuccess = false;

		try {
			yhteys = Database.getDBConnection();
			String sqlDelete = "DELETE FROM oluet WHERE olut_id = ?";
			stmtDelete = yhteys.prepareStatement(sqlDelete);
			stmtDelete.setInt(1, olut_id);
			int rowAffected = stmtDelete.executeUpdate();
			if (rowAffected == 1)
				updateSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			Database.closeDBConnection(stmtDelete, yhteys);
		}
		return updateSuccess;
	}

		//Etsi olut tietokannasta nimellä
		public List<Olut> findOlut(String nimi) {
		
		
			Connection yhteys = null;
			PreparedStatement stmtFind = null;
			ResultSet tulostaulu = null;
			List<Olut> oluet_loytyi = new ArrayList<Olut>(); // tyhjä Olutlista
			Olut olut = null; // apuviittausmuuttuja uuden Olutolion luontiin

	
			try {
				yhteys = Database.getDBConnection();
				//Vertaa syötettyä oluen nimeä tietokantaan hakusanalla, riittää että hakusana löytyy nimestä
				String sqlLause = "SELECT olut_id, olutNimi, maa, olutTyyppi, olutProsentit, olutArvosana FROM oluet WHERE olutNimi LIKE ?";
				stmtFind = yhteys.prepareStatement(sqlLause);
				stmtFind.setString(1, "%" + nimi + "%");  // haettu sana pitää olla muodossa "%?%"
				tulostaulu = stmtFind.executeQuery();
				while (tulostaulu.next()) {
					// luodaan Olutrivin tiedoista Olut-luokan olion
					olut = createOlutObjectFromRow(tulostaulu);
					// lisätään Olutolio listaan
					oluet_loytyi.add(olut);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				Database.closeDBConnection(tulostaulu, stmtFind, yhteys);
			}

			return oluet_loytyi; // palautetaan Olutlista
		}

		//Muokkaa olut
		public boolean editOlut(Olut olut) { //Muokkaus prosessin vaihe 2.
			Connection yhteys = null;
			PreparedStatement stmtInsert = null;
			boolean updateSuccess = false;

			try {
				yhteys = Database.getDBConnection();
				//Päivittää olemassaolevaa olut oliota sen id:n perusteella. Id numero saadaan muutaOlut metodilta
				String sqlInsert = "UPDATE oluet SET olutNimi = ?, maa = ?, olutTyyppi = ?, olutProsentit = ?, olutArvosana = ? WHERE olut_id = ?";
				stmtInsert = yhteys.prepareStatement(sqlInsert);
				stmtInsert.setString(1, olut.getNimi());
				stmtInsert.setString(2, olut.getmaa());
				stmtInsert.setString(3, olut.getTyyppi());
				stmtInsert.setDouble(4, olut.getProsentit());
				stmtInsert.setDouble(5, olut.getArvosana());
				stmtInsert.setInt(6, olut.getOlut_id());

				int rowAffected = stmtInsert.executeUpdate();
				if (rowAffected == 1)
					updateSuccess = true;

			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				Database.closeDBConnection(stmtInsert, yhteys);
			}
			return updateSuccess;
		}


		public Olut muutaOlut(int olut_id) { //Muokkaus prosessin vaihe 1.
				Connection yhteys = null;
				PreparedStatement stmtMuuta = null;
				ResultSet tulostaulu = null;
				Olut olut = null; // apuviittausmuuttuja uuden Olutolion luontiin
			

				try {
					//Valitsee muokattavan oluen tiedot id numeron perusteella ja lisää sen listaan
					yhteys = Database.getDBConnection();
					String sqlMuuta = "SELECT olut_id, olutNimi, maa, olutTyyppi, olutProsentit, olutArvosana FROM oluet WHERE olut_id = ?";
					stmtMuuta = yhteys.prepareStatement(sqlMuuta);
					stmtMuuta.setInt(1, olut_id);
					
					tulostaulu = stmtMuuta.executeQuery();
					while (tulostaulu.next()) {
						// luodaan Olutrivin tiedoista Olut-luokan olion
						olut = createOlutObjectFromRow(tulostaulu);
						// lisätään Olutolio listaan
					
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				} finally {
					Database.closeDBConnection(tulostaulu, stmtMuuta, yhteys);
				}
				return olut;
		}
}
