// const _ = require('lodash');

const Contact = require('./contact');

/**
 * This is Data Access Layer for contacts
 */
class ContactDao {

    /**
     * Default constructor
     */
    constructor (){
        console.log("ContactDao");
        // this._contacts = [
        //     new Contact(1, "Nantes, France", "0000011111"),
        //     new Contact(2, "Paris, France",  "0000011112"),
        //     new Contact(3, "Rennes, France", "0000011113")
        // ];

        this.contacts = [];

        for(let i=0; i< 3;i++){
            let contact = new Contact(i,'Dark' + i,'Vador' + i,i + ' rue','dagobah@' + i + '.com', i + '0000' + i);
            this.contacts.push(contact);
        }

        // console.log("ContactDao constructor :",this._contacts);
    }

    /**
     * Gets contacts list
     * @return {Array}
     */
    find (){
        console.log("ContactDao find :",this.contacts);
        // return this._contacts;
        return this.contacts;
    }

    /**
     * Finds a contact by id
     * @param id
     * @return {*}
     */
    findById (id){

        let contact = this.contacts.find((contact) => {
            return contact.id == id;
        });
        return contact;
        // return _(this._contacts).find( (contact) =>{
        //     return contact.id == id;
        // });
    }
    
    /**
     * Adds a contact
     * @param cont
     */
    create (contact){
        contact.id = this.contacts.length;
        console.log("ContactDao create :",contact);
        // this._contacts.push(contact);
        this.contacts.push(contact);
        return contact;
    }

    /**
     * Update a contact
     * @param contact
     */
    update (contact){
        console.log("ContactDao update :",contact);

        let c = this.findById(contact.id); 
        c.name = contact.name;
        c.firstname = contact.firstname;
        c.address = contact.address;
        c.email = contact.email;
        c.phone = contact.phone;
    }

    /**
     * Deletes a contact
     * @param contact
     */
    delete (contact){
        console.log("ContactDao delete :",contact);

         this.contacts = this.contacts.filter((c) => {
            return c.id != contact.id;
        });

         console.log("ContactDao delete :",this.contacts);

    	// _.remove(this._contacts, (_contact) => {    	
        // 	console.log("Compare " ,contact,_contact);
        //     return contact.id == _contact.id;
        // });
    }
}

module.exports = ContactDao;