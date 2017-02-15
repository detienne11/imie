package fr.imie.training.cdi13.dav.appjee.dal.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.training.cdi13.dav.appjee.dal.DALException;
import fr.imie.training.cdi13.dav.appjee.dal.Datasource;
import fr.imie.training.cdi13.dav.appjee.dal.dao.UserDAO;
import fr.imie.training.cdi13.dav.appjee.dal.dto.UserDTO;


public class UserDAOImpl implements UserDAO {

	private Datasource datasource;

	public UserDAOImpl() {
	}

	public void init(Datasource datasource) {
		this.datasource = datasource;
	}

	private Datasource getDatasource() {
		return this.datasource;
	}

	@Override
	public List<UserDTO> convertToDTO(ResultSet results) throws SQLException {
		final List<UserDTO> listeDTO = new ArrayList<>();

		while (results.next()) {
			UserDTO elt = new UserDTO();
			elt.setId(Integer.valueOf(results.getInt(UserDTO.ID)));
			elt.setNom(results.getString(UserDTO.NOM));
			elt.setPrenom(results.getString(UserDTO.PRENOM));
			elt.setConnectionId(results.getString(UserDTO.CONNECTION_ID));
			elt.setEmail(results.getString(UserDTO.EMAIL));
			elt.setPassword(results.getString(UserDTO.PASSWORD));
			elt.setActif(results.getBoolean(UserDTO.ACTIF));
			listeDTO.add(elt);
		}
		return listeDTO;
	}

	public List<UserDTO> find() throws DALException {

		final Datasource ds = this.getDatasource();
		Connection connection = null;
		final String query = "select * from utilisateur order by id";
		final PreparedStatement stmt = ds.prepareStatement(query);

		final List<UserDTO> records = (List<UserDTO>) ds.executeQuery(stmt, this);

		return records;
	}

	public UserDTO findById(Integer id) throws DALException {

		UserDTO record = null;

		final Datasource ds = this.getDatasource();
		Connection connection = null;
		final String query = "select * from utilisateur where id=?";
		final PreparedStatement stmt = ds.prepareStatement(query);

		try {
			connection = stmt.getConnection();
			stmt.setInt(1, id);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DALException(e);
		} finally {
			ds.closeConnection(connection, stmt, null);
		}

		List<UserDTO> records = (List<UserDTO>) ds.executeQuery(stmt, this);
		if (records != null && records.size() == 1) {
			record = (UserDTO) records.get(0);
		}

		return record;
	}

	public UserDTO create(UserDTO dto) throws DALException {

		final Datasource ds = this.getDatasource();
		Connection connection = null;
		final String query = "insert into utilisateur (nom,prenom,est_actif,id_connexion,mot_de_passe,email) values (?,?,?,?,?,?)";
		final PreparedStatement stmt = ds.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ResultSet resultSet = null;

		try {
			connection = stmt.getConnection();

			int index = 0;
			stmt.setString(++index, dto.getNom());
			stmt.setString(++index, dto.getPrenom());
			stmt.setBoolean(++index, dto.getActif());
			stmt.setString(++index, dto.getConnectionId());
			stmt.setString(++index, dto.getPassword());
			stmt.setString(++index, dto.getEmail());

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			ds.closeConnection(connection, stmt, null);
			throw new DALException(e);
		}

		Integer id = ds.executeCreate(stmt);
		dto.setId(id);

		return dto;

	}

	public void update(UserDTO dto) throws DALException {

		final Datasource ds = this.getDatasource();
		final String query = "update utilisateur set nom=?,prenom=?,est_actif=?,id_connexion=?,mot_de_passe=?,email=? where id=?";
		final PreparedStatement stmt = ds.prepareStatement(query);

		Connection connection = null;

		try {
			connection = stmt.getConnection();

			int index = 0;
			stmt.setString(++index, dto.getNom());
			stmt.setString(++index, dto.getPrenom());
			stmt.setBoolean(++index, dto.getActif());
			stmt.setString(++index, dto.getConnectionId());
			stmt.setString(++index, dto.getPassword());
			stmt.setString(++index, dto.getEmail());
			// where
			stmt.setInt(++index, dto.getId());

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			ds.closeConnection(connection, stmt, null);
			throw new DALException(e);
		}

		int results = ds.executeUpdate(stmt);
	}

	public void delete(UserDTO dto) throws DALException {

		final Datasource ds = this.getDatasource();
		final String query = "delete from utilisateur where id=?";
		final PreparedStatement stmt = ds.prepareStatement(query);

		Connection connection = null;

		try {
			connection = stmt.getConnection();
			stmt.setInt(1, dto.getId());

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			ds.closeConnection(connection, stmt, null);
			throw new DALException(e);
		}

		int results = ds.executeUpdate(stmt);

	}

	public void checkUser(String login, String password) throws DALException {
		throw new DALException("service non implementer");

	}

}
