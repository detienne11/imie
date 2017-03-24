import { Component } from '@angular/core';
import { Contact } from './contact';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
  
export class AppComponent {  
  contacts : any = [];  
  title = 'TP Angular';

  saisie= null;

  // contactForm = {
  //   name: '',
  //   address: '',
  //   phone: ''
  // };
  
  contactForm : Contact = new Contact(0,null,null,null);

  contactForm2 : Contact = new Contact(-1,null,null,null);

  constructor(){

    for(let i=0; i< 5;i++){

      let contact = new Contact(i,'Dark Vador' + i,i + ' rue', i + '0000' + i);
      
      // let contact = {
      //   id: i,
      //   name:  'Dark',
      //   address: 'Vador',
      //   phone: '0660276552'
      // };

      this.contacts.push(contact);
    }
  }

  pairList(){
    var liste=[];
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
    console.log(this.contactForm);

    // let contact = {
    //   name: this.contactForm.name,
    //   address: this.contactForm.address,
    //   phone: this.contactForm.phone
    // };

    let contact = new Contact(0, this.contactForm.name, this.contactForm.address, this.contactForm.phone);

    console.log(contact);

    this.contacts.push(contact);
  }

  addContact2(newContact) {
    newContact.id = this.contacts.length + 1;
    console.log(newContact);
    this.contacts.push(newContact);
  }

}
