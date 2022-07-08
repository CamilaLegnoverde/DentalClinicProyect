fetch("url")
	.then(function(response){
		return response.json()
})
	.then(function(dataDecode){
		console.log(dateDecode)
})