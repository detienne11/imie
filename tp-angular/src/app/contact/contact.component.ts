import { Component, OnInit } from '@angular/core';
import { Contact } from '../contact';
import { ContactsService } from '../contacts.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  contact : Contact;

  constructor(private contactsService : ContactsService) {

  }

  ngOnInit() {
      this.contact = this.contactsService.getContact(0);
  }

}
