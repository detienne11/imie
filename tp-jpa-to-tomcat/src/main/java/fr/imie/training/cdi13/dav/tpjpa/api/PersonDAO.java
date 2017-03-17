package fr.imie.training.cdi13.dav.tpjpa.api;

import java.util.List;

public interface PersonDAO {

	public List<Person> find();
	
	public Person find(Integer id);
	
	public Person find(Person person);
	
	public void create(Person person);
	
	public void update(Person person);
	
	public void delete(Person person);
	
	public void delete(Integer id);
	
	public void exception();
	
}
