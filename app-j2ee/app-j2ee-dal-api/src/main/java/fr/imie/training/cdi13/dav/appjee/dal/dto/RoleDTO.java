package fr.imie.training.cdi13.dav.appjee.dal.dto;

public class RoleDTO implements DTO {

	public final static String ID = "id";
	public final static String NAME = "name";
	public final static String ORDER = "order";

	private Integer id = null;

	private String nom = null;
	
	private Integer order = null;

	public RoleDTO() {
		super();
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

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

}
