package fr.imie.training.cdi13.dav.jdbc.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.imie.training.cdi13.dav.jdbc.Application;
import fr.imie.training.cdi13.dav.jdbc.ApplicationException;

public class TP0ApplicationImpl implements Application {

	private Connection con;

	public TP0ApplicationImpl() {
	}

	@Override
	public String getNom() {
		return "TP0 sans couche";
	}

	@Override
	public void init() throws ApplicationException {
		try {
			this.con = DriverManager.getConnection("jdbc:postgresql://10.1.2.72:5432/jdbcfcpe", "postgres", "postgres");
		} catch (SQLException e) {
			
			try {
				if (this.con != null && !this.con.isClosed()) {
					this.con.close();
				}
			} catch (SQLException e1) {
				System.err.println(e1.getMessage());
			}
			
			throw new ApplicationException(e.getMessage());
		}
	}

	@Override
	public void stop() throws ApplicationException {
		try {
			if (this.con != null && !this.con.isClosed()) {
				this.con.close();
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new ApplicationException(e.getMessage());
		}
	}

	@Override
	public void start() throws ApplicationException {

		Statement stmt = null;
		ResultSet results = null;

		try {
			final String query = "select * from etablissement";
			stmt = this.con.createStatement();
			results = stmt.executeQuery(query);

			StringBuffer str = new StringBuffer();
			while (results.next()) {
				str.append("Etablissement : ");
				str.append(results.getInt("id"));
				str.append(", ");
				str.append(results.getString(2));
				str.append("\n");
			}
			System.out.print(str.toString());

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {

			try {
				if (results != null && !results.isClosed()) {
					results.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}

		}

	}

}
