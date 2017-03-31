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
topic.setId(1);
topic.setId("Front-end");
// console.log("Topic",topic);

const contact = new Contact();
contact.setId(1);
contact.setAddress("avenue Dark vador");
// console.log("Contact",contact);

const mission = new Mission();
mission.setId(1);
// console.log("Mission",mission);

const mission2 = new Mission();
mission2.setId(2);
// console.log("Mission",mission2);

const training = new Training();
training.setId(1);
training.setName("AngularJS");
// console.log("Training",training);

const training2 = new Training();
training2.setId(2);
training2.setName("Angular 2");
// console.log("Training",training2);

const employee = new Employee();
employee.setId(1);
employee.setName("Vador");

const employee2 = new Employee();
employee2.setId(2);
employee2.setName("Luke");

employee.register(training2);
employee.assign(mission);
employee2.register(training);
employee.assign(mission2);

console.log("Employee1",employee);
console.log("Employee2",employee2);
console.log("Training",training);
console.log("Training2",training2);
console.log("Mission1",mission);
console.log("Mission2",mission2);

employee.unregister(training2);
employee.detach(mission2);

training.unregister(employee2);
mission.detach(employee2);
