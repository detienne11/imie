package fr.imie.cdi13.training.jdbc.dav.dto;

public class EtablissementDTO implements DTO {

	private Integer id = null;
	
	private String nom = null;
	
	private Integer numRue = null;
	
	private String nomRue = null;
	
	private String codePostal = null;
	
	private String ville = null;

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

	public Integer getNumRue() {
		return numRue;
	}

	public void setNumRue(Integer num_rue) {
		this.numRue = num_rue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "EtablissementDTO [id=" + id + ", nom=" + nom + ", numRue=" + numRue + ", nomRue=" + nomRue
				+ ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
}
