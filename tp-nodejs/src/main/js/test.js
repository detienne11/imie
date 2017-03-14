
// process.stdin.pipe(process.stdout);

process.stdin.on('data', function (data){
	process.stdout.write(data);
});