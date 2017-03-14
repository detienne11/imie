var fs = require('fs');
var zlib = require('zlib');

// Copy de fichier
//var source = fs.createReadStream('x:/javaee-api-7.0.jar');
//var dest = fs.createWriteStream('x:/javaee-api-7.0-copy.jar');
//
//source.pipe(dest);

// Fichier Compresser
var source = fs.createReadStream('x:/example-cv1.pdf');
var z = zlib.createGzip();
var w  = fs.createWriteStream('x:/example.pdf.gz');
source.pipe(z).pipe(w);


// Fichier de log
//var file  = fs.createWriteStream('x:/file.log');
//process.stdin.pipe(file);