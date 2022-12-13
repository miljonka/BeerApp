package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * Luokka toteuttaa
 * tietokantayhteyden muodostavan getDBConnection-metodin 
 * ja erilaisia tietokantayhteyden sulkevia closeDBConnection-metodeja
 *
 */
public class Database {

	/**
	 * Antaa tietokantayhteyden
	 * 
	 * @return connection - tietokantayhteys
	 */
	public static Connection getDBConnection() {
		Connection connection = null;			

		// Alkumääritykset
		String username = DBAccounts.DBUSERNAME;  
		String password = DBAccounts.DBPASSWORD;
		String url = DBAccounts.DBURL;

		try {
			// Ladataan ajuri
			Class.forName("org.sqlite.JDBC");  // SQLite-tietokanta-ajuri käyttöön

			// Avataan yhteys connection-nimiseen muuttujaan
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

	/**
	 * Sulkee Statementin ja Connectionin
	 * 
	 * @param SQL-statement
	 * @param Tietokantayhteys
	 */
	public static void closeDBConnection(Statement stmt, Connection connection) {
		closeDBConnection(null, stmt, connection);
	}

	/**
	 * Sulkee ResultSetin, Statementin ja Connectionin
	 */
	public static void closeDBConnection(ResultSet rs, Statement stmt, Connection conn) {

		try {
			if (rs != null) { // Suljetaan rs (palautettu tulostaulu), mikäli
								// olemassa
				rs.close();
			}
			if (stmt != null) { // Suljetaan stmt (SQL-statement), mikäli
								// olemassa
				stmt.close();
			}
			if (conn != null) { // Suljetaan conn (yhteys), mikäli olemassa
				conn.close();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}