package fr.imie.training.cdi13.dav.jdbc.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.training.cdi13.dav.jdbc.dal.Datasource;
import fr.imie.training.cdi13.dav.jdbc.dal.dao.EtablissementDAO;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;
import fr.imie.training.cdi13.dav.jdbc.model.dto.EtablissementDTO;

public class EtablissementDAOImpl implements EtablissementDAO {

	private Datasource datasource;

	public EtablissementDAOImpl() {
	}

	@Override
	public void init(Datasource datasource) {
		this.datasource = datasource;
	}

	public Datasource getDatasource() {
		return this.datasource;
	}

	@Override
	public List<DTO> convertToDTO(final ResultSet results) throws SQLException {

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
		Connection connection = null;
		final String query = "select * from etablissement where id=?";
		PreparedStatement stmt = null;
		ResultSet results = null;

		try {
			connection = this.getDatasource().openConnection();
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);
			results = stmt.executeQuery();
			List<DTO> records = this.convertToDTO(results);
			if (records != null && records.size() == 1) {
				record = records.get(0);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {

			this.getDatasource().closeConnection(connection, stmt, results);
		}

		return record;
	}

	@Override
	public List<DTO> find() {

		List<DTO> records = null;
		String query = "select * from etablissement";
		try {
			records = this.getDatasource().executeQuery(query,this);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return records;
	}

	@Override
	public DTO create(DTO dto) {

		EtablissementDTO eltDto = (EtablissementDTO) dto;

		String query = "insert into etablissement (nom,num_rue,nom_rue,code_postal,ville) values (?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		int nbRow;

		try {

			connection = this.getDatasource().openConnection();
			stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

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

			this.getDatasource().closeConnection(connection, stmt, null);
		}

		return eltDto;

	}

	@Override
	public void update(DTO dto) {

		EtablissementDTO eltDto = (EtablissementDTO) dto;
		Connection connection = null;
		final String query = "update etablissement set nom=?,num_rue=?,nom_rue=?,code_postal=?,ville=? where id=?";
		PreparedStatement stmt = null;
		int results;

		try {

			connection = this.getDatasource().openConnection();
			stmt = connection.prepareStatement(query);

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
			this.getDatasource().closeConnection(connection, stmt, null);
		}

	}

	@Override
	public void delete(DTO dto) {
		EtablissementDTO eltDto = (EtablissementDTO) dto;
		Connection connection = null;
		String query = "delete from etablissement where id=?";
		PreparedStatement stmt = null;
		int results;

		try {

			connection = this.getDatasource().openConnection();
			stmt = connection.prepareStatement(query);

			stmt.setInt(1, eltDto.getId());

			results = stmt.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			this.getDatasource().closeConnection(connection, stmt, null);
		}

	}

}
