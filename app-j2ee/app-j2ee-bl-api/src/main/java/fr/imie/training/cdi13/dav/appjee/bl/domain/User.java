package fr.imie.training.cdi13.dav.appjee.bl.domain;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;
import fr.imie.training.cdi13.dav.appjee.dal.dto.UserDTO;
import fr.imie.training.cdi13.dav.jpa.entity.Utilisateur;

public class User implements BO<UserDTO> {

	public final static String ID = "id";
	public final static String NOM = "nom";
	public final static String PRENOM = "prenom";
	public final static String ACTIF = "est_actif";
	public final static String CONNECTION_ID = "id_connexion";
	public final static String PASSWORD = "mot_de_passe";
	public final static String EMAIL = "email";

	private BO.STATE state = null;

	private Integer id = null;

	private String nom = null;

	private String prenom = null;

	private Boolean actif = null;

	private String connectionId = null;

	private String password = null;

	private String email = null;

	private Role role = null;

	public User() {
		super();
	}

	public BO.STATE getState() {
		return state;
	}

	public void setState(BO.STATE state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public UserDTO convertToDTO() {
		UserDTO dto = new UserDTO();
		dto.setId(this.getId());
		dto.setNom(this.getNom());
		dto.setPrenom(this.getPrenom());
		dto.setEmail(this.getEmail());
		dto.setConnectionId(this.getConnectionId());
		dto.setPassword(this.getPassword());
		dto.setActif(this.getActif());
		return dto;
	}

	@Override
	public void setFromDTO(UserDTO dto) throws BusinessException {

		if (dto == null) {
			throw new BusinessException("convert DTO to BO failed");
		}

		this.setId(dto.getId());
		this.setNom(dto.getNom());
		this.setPrenom(dto.getPrenom());
		this.setEmail(dto.getEmail());
		this.setConnectionId(dto.getConnectionId());
		this.setPassword(dto.getPassword());
		this.setActif(dto.getActif());

	}

	public void setFromDTO(Utilisateur dto) throws BusinessException {
		if (dto == null) {
			throw new BusinessException("convert JPA DTO to BO failed");
		}
		this.setId(dto.getId());
		this.setNom(dto.getNom());
		this.setPrenom(dto.getPrenom());
		this.setEmail(dto.getEmail());
		this.setConnectionId(dto.getIdConnexion());
		this.setPassword(dto.getMotDePasse());
		this.setActif(dto.getEstActif());
	}

	public void populateToEntity(Utilisateur entity) {

		entity.setId(this.getId());
		entity.setNom(this.getNom());
		entity.setPrenom(this.getPrenom());
		entity.setEmail(this.getEmail());
		entity.setIdConnexion(this.getConnectionId());
		entity.setMotDePasse(this.getPassword());
		entity.setEstActif(this.getActif());
	}

}
