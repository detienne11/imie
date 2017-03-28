export class Contact {

    id : number;
    name: string;
    firstname: string;
    address: string;
    email: string;
    phone: string;

    constructor(id,name,firstname,address,email,phone){
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}
