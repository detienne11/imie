/**
 * IMPORT EXTERNE
 */

/**
 * IMPORT INTERNE
 */
const Contact = require('./model/contact.js').Contact;
const Topic = require('./model/topic.js').Topic;
const Employee = require('./model/employee.js').Employee;
const Mission = require('./model/mission.js').Mission;
const Training = require('./model/training.js').Training;

const topic = new Topic();
console.log("Topic",topic);

const contact = new Contact();
console.log("Contact",contact);

const mission = new Mission();
console.log("Mission",mission);

const training = new Training();
console.log("Training",training);

const employee = new Employee();
console.log("Employee",employee);