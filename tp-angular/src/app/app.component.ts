import { Component, OnInit } from '@angular/core';
import { Contact } from './contact';
import { ContactsService } from './contacts.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
  
export class AppComponent implements OnInit {  
  contacts : any = [];  
  title = 'TP Angular';

  saisie= null;

  // contactForm = {
  //   name: '',
  //   address: '',
  //   phone: ''
  // };
  
  contactForm : Contact = new Contact(0,null,null,null,null,null);

  contactForm2 : Contact = new Contact(-1,null,null,null,null,null);

  selectedContact : Contact = new Contact(-1,null,null,null,null,null);;

  constructor(private contactsService : ContactsService){
   
  }

  ngOnInit() {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    console.log("AppComponent ngOnInit");
    this.contactsService.getContacts().subscribe(data => {this.contacts = data});    
  }

  pairList(){
    var liste=[];
    console.log(this.contacts);
    for (let contact of this.contacts){
      if ((contact.id % 2) == 0){
        liste.push(contact);
      }
   }
   return liste;
  }

  renderContacts(contact) {   
    return contact.id + ' ' + contact.name + '-' + contact.address + ':' + contact.phone;
  }

  addContact() {
    console.log("AppComponent : addContact",this.contactForm);

    // let contact = {
    //   name: this.contactForm.name,
    //   address: this.contactForm.address,
    //   phone: this.contactForm.phone
    // };

    let contact = new Contact(0, this.contactForm.name, null,this.contactForm.address, null,this.contactForm.phone);

    this.addContact2(contact);

  }

  addContact2(newContact) {

    console.log("AppComponent : addContact2", newContact);

    this.contactsService.addContact(newContact).subscribe( contact => {
      this.contacts.push(contact);
    });
  }

  updContact(contact) {
    console.log("AppComponent : updContact", contact);
    this.contactsService.updateContact(contact);
  }

  delContact(contact){
    console.log("AppComponent : delContact", contact);
    this.contactsService.deleteContact(contact);
  }
  
  onCreateContact(contact: Contact) {
    console.log("AppComponent : onCreateContact", contact);
    this.contactsService.addContact(contact).subscribe( contact => {
      this.contacts.push(contact);
    });
  }

  onUpdateContact(contact: Contact) {
    console.log("AppComponent : onUpdateContact", contact);
    this.contactsService.updateContact(contact);
  }

  onDeleteContact(contact: Contact) {
    console.log("AppComponent : onDeleteContact", contact);
    this.contactsService.deleteContact(contact).subscribe (() => {
        this.contacts = this.contacts.filter((c) => {
            return c.id != contact.id;
        });
    });
  }

  onSelectContact(contact : Contact) {
     console.log("AppComponent : onSelectContact", contact);
     this.selectedContact = contact;
  }

}
