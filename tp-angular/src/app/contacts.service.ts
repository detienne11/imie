import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Contact } from './contact';

// import { Observable } from 'rxjs/Rx';
// import {Observable} from '@reactivex/rxjs/es6/Observable.js';

 import "rxjs/add/operator/map";

@Injectable()
export class ContactsService {

  private headers : Headers;
  private options : RequestOptions;

  constructor(private http: Http) { 
    this.headers = new Headers({'Content-Type' : 'application/json'});
    this.options = new RequestOptions({headers: this.headers});
  }

  contacts : any = [];  

  getContacts () {

    console.log("ContactsService : getContacts");

    return this.http.get("/api/contacts",{}).map(res => res.json());
  }

  getContact(id : Number){
    console.log("ContactsService : getContact id=", id);
    var c = null;
    for (let contact of this.contacts){
      if (contact.id == id){
        c = contact;
        break;
      }
    }
    return  c;
  }

  addContact(contact : Contact){
    // contact.id = this.contacts.length;
    // console.log("ContactsService : addContact ", contact);
    // this.contacts.push(contact);
    return this.http
      .post('/api/contacts', JSON.stringify(contact), this.options)
      .map( res => res.json());
  }

  updateContact(contact : Contact){    
    console.log("ContactsService : updateContact ", contact);
    this.http.put('/api/contacts', JSON.stringify(contact), this.options);
  }
    
  deleteContact(contact : Contact){    
    console.log("ContactsService : deleteContact ", contact);
    this.http.delete('/api/contacts/' + contact.id, this.options);
  }

}
