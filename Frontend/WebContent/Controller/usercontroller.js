/**
* Link2Controller
*/
app.controller('UserController')

$scope.registerUser=function(){
	console.log("USER DATA IS "+$scope.user)
	UserService.registerUser($scope.user).then(function(response){
	console.log(response.data)
	console.log(response.status)
	$location.path('/home')
},function(response){
	console.log(response.data)
	console.log(response.status)
	$scope.error=response.data
	$location.path('/register')
})
}
$scope.login=function(){
	console.log($scope.user)
	UserService.login($scope.user).then(function(response){
	$location.path('/home')
},function(response){
	$scope.error=response.data.message
	$location.path('/login')
})
}