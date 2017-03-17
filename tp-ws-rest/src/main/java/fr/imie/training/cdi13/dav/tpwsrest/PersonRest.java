package fr.imie.training.cdi13.dav.tpwsrest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.imie.training.cdi13.dav.tpjpa.api.Person;
import fr.imie.training.cdi13.dav.tpjpa.api.PersonDAO;
import fr.imie.training.cdi13.dav.tpjpa.impl.PersonDAOImpl;



@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonRest {
	
	private PersonDAO personDAO = null;
	
	private PersonDAO getPersonDAO(){
		if (this.personDAO == null){
			this.personDAO = new PersonDAOImpl();
		}
		return this.personDAO;
	}
	
	@GET
	@Path("/ping")
	public Response ping(){
		return Response.ok("--PING--").build();
	}
	
	@GET
	public List<Person> findAll(){
		List<Person> personList = this.getPersonDAO().find();
//		List<Person> personList = new ArrayList<>();
		return personList;
	}
	
	@GET
	@Path("{id}")
	public Person findById(@PathParam("id") Integer id){
//		Person person = new Person();
//		person.setFirstName("Dark");
//		person.setLastName("Vador");
//		System.out.println(person);
		Person person = this.getPersonDAO().find(id);
		System.out.println(person);
		return person;
		
//		return Response.ok(person).build();
	}
	
	@POST
	public Response create(Person person){		
		System.out.println("--POST--" + person);		
		return Response.ok("--POST--" + person).build();
	}
	
	@PUT
	public Response update(Person person){
		System.out.println("--PUT--" + person);
		return Response.ok("--PUT--" + person).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Integer id){
		System.out.println("--DELETE--" + id);
		return Response.ok("--DELETE--").build();
	}
}
