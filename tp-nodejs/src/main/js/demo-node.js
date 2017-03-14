var fs = require("fs");


var url = 'X:/training/tp-nodejs/samples.json';
// 
var file = fs.readFileSync(url) ;
console.log(file) ;
//-> '[ { ''nom'' : ''Doe'', ''prenom'' : ''John'' } ]'

var file = fs.readFile(url , function(err,data) {
	console.log(err);
	console.log('async', data) ;
}) ;

console.log('sync', file) ;

//-> sync undefined
//-> async '[ { ''nom'' : ''Doe'', ''prenom'' : ''John'' } ]'

// process.stdin.pipe(process.stdout);

process.stdin.on('data', function (data){
	process.stdout.write(data);
});