package fr.imie.emanagerws.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.imie.emanagerws.entity.Contact;
import fr.imie.emanagerws.service.Service;

@Path("/contacts")
@Produces({MediaType.APPLICATION_JSON})

public class ContactResource {

    private final Service service;

    public ContactResource(Service service){
        this.service = service;
    }

    @GET
    public List<Contact> getContacts (){
        return this.service.getContacts();
    }

    @GET
    @Path("/{id}")
    public Contact getContactByIdWithPathParam(@PathParam("id") final long id){
    	return this.service.findContactById(id);
    }
    
    @POST
    public void createContact(Contact contact) {
    	System.out.println("POST INSERT Contact " + contact);
    	this.service.addContact(contact);
    }
    
    @PUT
    public void updateContact(Contact contact) {
    	System.out.println("PUT UPDATE Contact " + contact);
    	this.service.updateContact(contact);
    }
    
    @DELETE
    public void deleteContact(Contact contact){
    	System.out.println("DELETE Contact " + contact);
    	this.service.deleteContact(contact);
    }
}
