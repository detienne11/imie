import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Contact } from '../contact';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  @Input()
  contact: Contact;

  @Output()
  create: EventEmitter<Contact> = new EventEmitter();

  @Output()
  update: EventEmitter<Contact> = new EventEmitter();

  @Output()
  delete: EventEmitter<Contact> = new EventEmitter();

  constructor() {
    console.log("ContactComponent : constructor",this.contact);
  }

  ngOnInit() {
    console.log("ContactComponent : ngOnInit",this.contact);
  }

  createContact(contact) {
    console.log("ContactComponent : createContact", this.contact);
    this.create.emit(this.contact);
  }

  updateContact(contact) {
    console.log("ContactListComponent : updateContact", this.contact);
     this.update.emit(this.contact);
  }

  deleteContact(contact){
    console.log("ContactListComponent : deleteContact", this.contact);
     this.delete.emit(this.contact);
  }

}
