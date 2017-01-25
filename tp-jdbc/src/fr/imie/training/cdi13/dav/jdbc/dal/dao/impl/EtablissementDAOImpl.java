package fr.imie.training.cdi13.dav.jdbc.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.training.cdi13.dav.jdbc.dal.dao.EtablissementDAO;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;
import fr.imie.training.cdi13.dav.jdbc.model.dto.EtablissementDTO;

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
	public DTO findById(Integer id) {

		DTO record = null;

		final String query = "select * from etablissement where id=?";
		PreparedStatement stmt = null;
		ResultSet results = null;

		try {

			stmt = this.getCnx().prepareStatement(query);
			stmt.setInt(1, id);
			results = stmt.executeQuery();
			List<DTO> records = this.convertToDTO(results);
			if (records != null && records.size() == 1) {
				record = records.get(0);
			}

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

		return record;
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
	public DTO create(DTO dto) {

		EtablissementDTO eltDto = (EtablissementDTO) dto;

		String query = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		int nbRow;

		try {

			query = "insert into etablissement (nom,num_rue,nom_rue,code_postal,ville) values (?,?,?,?,?)";
			stmt = this.getCnx().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, eltDto.getNom());
			stmt.setInt(2, eltDto.getNumRue());
			stmt.setString(3, eltDto.getNomRue());
			stmt.setString(4, eltDto.getCodePostal());
			stmt.setString(5, eltDto.getVille());

			nbRow = stmt.executeUpdate();

			resultSet = stmt.getGeneratedKeys();
			if (resultSet.next()) {
				eltDto.setId(resultSet.getInt("id"));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {

			try {

				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}

				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}

			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}

		return eltDto;

	}

	@Override
	public void update(DTO dto) {

		EtablissementDTO eltDto = (EtablissementDTO) dto;

		String query = null;
		PreparedStatement stmt = null;
		int results;

		try {

			query = "update etablissement set nom=?,num_rue=?,nom_rue=?,code_postal=?,ville=? where id=?";
			stmt = this.getCnx().prepareStatement(query);

			stmt.setString(1, eltDto.getNom());
			stmt.setInt(2, eltDto.getNumRue());
			stmt.setString(3, eltDto.getNomRue());
			stmt.setString(4, eltDto.getCodePostal());
			stmt.setString(5, eltDto.getVille());
			stmt.setInt(6, eltDto.getId());

			results = stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {

			try {
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}

			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}

	}

	@Override
	public void delete(DTO dto) {
		EtablissementDTO eltDto = (EtablissementDTO) dto;

		String query = null;
		PreparedStatement stmt = null;
		int results;

		try {

			query = "delete from etablissement where id=?";
			stmt = this.getCnx().prepareStatement(query);

			stmt.setInt(1, eltDto.getId());

			results = stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {

			try {
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}

			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}

	}

}
