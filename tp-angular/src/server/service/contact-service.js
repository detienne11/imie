const Contact = require('./contact');
const ContactDao = require('./contact-data');

/**
 * This is a Business Access Layer for contacts
 */
class ContactService {

    /**
     * Default contructor
     */
    constructor (){
        this.dao = new ContactDao();
    }

    /**
     * Get contacts
     * @return {Array}
     */
    find (){
        console.log("ContactService find");
        return this.dao.find();
    }

        /**
     * Finds a contact by id
     * @param id
     * @return {*}
     */
    findById (id){
         console.log("ContactService findById",id);
        return this.dao.findById(id);
    }

    /**
     * Adds a contact
     * @param contact
     */
    addContact (contact){
        console.log("ContactService addContact",contact);
        return this.dao.create(contact);
    }

    /**
     * Update a contact
     * @param contact
     */
    updateContact (contact){
        console.log("ContactService updateContact",contact);
        this.dao.update(contact);
    }

    /**
     * Deletes a contact
     * @param contact
     */
    deleteContact (contact){
        console.log("ContactService deleteContact",contact);
        this.dao.delete(contact);
    }
}

module.exports = ContactService;