import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { Contact } from '../contact';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent implements OnInit {

  @Input()
  contacts: Contact[];

  @Output()
  select: EventEmitter<Contact> = new EventEmitter();

  constructor() { 
    console.log("ContactListComponent : constructor",this.contacts);
  }

  ngOnInit() {
    console.log("ContactListComponent : ngOnInit",this.contacts);
  }

  selectContact(contact) {
    console.log("ContactListComponent : selectContact", contact);
    this.select.emit(contact);
  }

}
