
class Contact {

    /**
     * The constructor
     *
     * @param {number} id : the identifier
     * @param {string} name : the name
     * @param {string} address : the address
     * @param {string} phone : the phone
     */
    constructor(id,name,firstname,address,email,phone){
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}

module.exports = Contact;