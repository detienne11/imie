package fr.imie.cdi13.training.jdbc.dav.dal.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.cdi13.training.jdbc.dav.dal.dao.EtablissementDAO;
import fr.imie.cdi13.training.jdbc.dav.dto.DTO;
import fr.imie.cdi13.training.jdbc.dav.dto.EtablissementDTO;

public class EtablissementDAOImpl implements EtablissementDAO {

	private final Connection cnx;

	public EtablissementDAOImpl(Connection cnx) {
		this.cnx = cnx;
	}

	private Connection getCnx() {
		return this.cnx;
	}

	private List<DTO> convertToDTO(final ResultSet results) throws SQLException {

		final List<DTO> listeDTO = new ArrayList<>();

		while (results.next()) {
			EtablissementDTO elt = new EtablissementDTO();
			elt.setId(Integer.valueOf(results.getInt("id")));
			elt.setNom(results.getString("nom"));
			elt.setNumRue(Integer.valueOf(results.getInt("num_rue")));
			elt.setNomRue(results.getString("nom_rue"));
			elt.setCodePostal(results.getString("code_postal"));
			elt.setVille(results.getString("ville"));
			listeDTO.add(elt);
		}
		return listeDTO;
	}

	@Override
	public List<DTO> find() {

		List<DTO> records = null;

		String query = null;
		Statement stmt = null;
		ResultSet results = null;

		try {

			query = "select * from etablissement";
			stmt = this.getCnx().createStatement();
			results = stmt.executeQuery(query);
			records = this.convertToDTO(results);

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
		return records;
	}

	@Override
	public void create(DTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(DTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(DTO dto) {
		// TODO Auto-generated method stub

	}

}
