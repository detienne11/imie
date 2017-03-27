const express = require ('express');
const router = express.Router();

const Contact = require('../../server/service/contact');
const ContactService = require('../../server/service/contact-service');
const contactService = new ContactService();

router.get('/contacts',(req, res) => {
    console.log('get url=/contacts');
	let contacts = contactService.find();	
    res.json(contacts);
	// res.send(contacts);
});

router.get('/contacts/:id', (req, res) => {
    console.log('get url=/contacts/:id');
    let contact = contactService.findById(req.params.id);
    res.json(contact);
});

router.post('/contacts', (req, res) => {
	console.log('post url=/contacts');

	let contact = new Contact(null,req.body.name,req.body.address,req.body.phone);
	contact = contactService.addContact(contact);
	
	res.json(contact);
});

router.put('/contacts', (req, res) => {
	console.log('put url=/contacts');
	
	let contact = new Contact(req.body.id,req.body.name,req.body.address,req.body.phone);

	contactService.updateContact(contact);
	res.status('200').end();
});

router.delete('/contacts', (req, res) => {
	console.log('delete url=/contacts');
	
	let contact = {
		id : req.body.id
	};
	
	contactService.deleteContact(contact);
	
	res.status('200').end();
});

module.exports = router;
