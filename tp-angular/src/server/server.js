/**
 * IMPORT EXTERNE
 */
const express = require('express') ;
const path = require('path') ;
const http = require('http') ;
const bodyParser = require('body-parser');
// const morgan = require('morgan');             // log requests to the console (express4)

/**
 * IMPORT INTERNE
 */
 const api = require('../app/routes/contact-api');

/**
 * CONFIG
 */
const app = express();
const server = http.createServer(app);
const port = '9484';

// MIDDLWARE
// app.use(morgan('dev'));   
app.use(bodyParser.json());  // parse application/json
app.use(bodyParser.urlencoded({extened: true}));

// CONFIG 
app.set('port', port);
// app.set('views',path.join(__dirname,'../webapp/views'));
// app.set('view engine','ejs');

app.use(express.static(path.join(__dirname, '../../dist')));

app.use('/api', api);

app.get('*', function (req, res) {
	res.sendFile(path.join(__dirname, '../../dist/index.html'));
});

server.listen(port, () => console.log("Server listen to : " + port));
