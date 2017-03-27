
class Contact {

    /**
     * The constructor
     *
     * @param {number} id : the identifier
     * @param {string} name : the name
     * @param {string} address : the address
     * @param {string} phone : the phone
     */
    constructor(id,name,address,phone){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}

module.exports = Contact;