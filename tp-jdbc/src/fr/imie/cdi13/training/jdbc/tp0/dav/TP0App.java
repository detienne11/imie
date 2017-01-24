package fr.imie.cdi13.training.jdbc.tp0.dav;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TP0App {

	public static void main(String[] args) {

		Connection con = null;
		String query = null;
		Statement stmt = null;
		ResultSet results = null;
				
		try {
			con = DriverManager.getConnection("jdbc:postgresql://10.1.2.72:5432/jdbcfcpe","postgres","postgres");
			query = "select * from etablissement";
			stmt = con.createStatement();
			results = stmt.executeQuery(query);
			
			
			StringBuffer str = new StringBuffer(); 
			while (results.next()) {
				str.append("Etablissement : ");
				str.append(results.getInt("id"));
				str.append(", ");
				str.append(results.getString(2));
				str.append("\n");
			}
			System.out.println(str.toString());
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
//			e.printStackTrace();			
		} finally {
			
			try {
				if (results != null
						&& !results.isClosed()) {
					results.close();
				}
				if (stmt != null
						&& !stmt.isClosed()) {
					stmt.close();
				}
				if (con != null
						&& !con.isClosed()) {
					con.close();
				}
				
			} catch (SQLException e) {
				System.err.println(e.getMessage());
//				e.printStackTrace();
			}
			
		}

	}

}
