package fr.imie.training.cdi13.dav.tpjpa.api;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="flights")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	@JoinTable(name="FLIGHT_AIRPORT",
		joinColumns=@JoinColumn(name="ID_FLIGHT",referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_AIRPORT",referencedColumnName="ID")
	)
	private List<Airport> airportList = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Airport> getAirportList() {
		if (this.airportList == null) {
			this.airportList = new ArrayList<>();
		}
		return this.airportList;
	}

	public void addAirport(Airport airport) {
		this.getAirportList().add(airport);
	}

	public void removeAirport(Airport airport) {
		this.getAirportList().remove(airport);
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airportList=" + airportList + "]";
	}

}
