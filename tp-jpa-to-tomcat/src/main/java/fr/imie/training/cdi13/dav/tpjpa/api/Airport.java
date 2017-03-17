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
@Table(name="airports")
public class Airport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
		joinColumns=@JoinColumn(name="ID_AIRPORT",referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_FLIGHT",referencedColumnName="ID")
	)
	private List<Flight> flightList = null;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Flight> getFlightList() {
		if (flightList == null){
			flightList = new ArrayList<>();
		}
		return flightList;
	}
	
	public void addAirport(Flight flight) {
		this.getFlightList().add(flight);
	}

	public void removeAirport(Flight flight) {
		this.getFlightList().remove(flight);
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", flightList=" + flightList + "]";
	}

	
}
