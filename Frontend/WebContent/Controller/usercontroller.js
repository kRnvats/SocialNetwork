/**
* Link2Controller
*/
app.controller('UserController',function($scope,UserService,$location,$rootScope,$cookieStore){

$scope.registerUser=function(){
	console.log("USER DATA IS "+$scope.user)
	UserService.registerUser($scope.user).then(function(response){
	console.log(response.data)
	console.log(response.status)
	$location.path('/Login')
},function(response){
	console.log(response.data)
	console.log(response.status)
	$scope.error=response.data;
	$location.path('/Register')
})
}
$scope.login=function(){
	console.log($scope.userObj)
	UserService.login($scope.user).then(function(response){
		$rootScope.currentUser=response.data
		$cookieStore.put('userDetails',response.data);
		console.log(response.data);
		console.log(response.status);
		$location.path('/Home')
},function(response){
	$scope.error=response.data.message;
	$location.path('/Login')
		})
	}
	if ($rootScope.currentUser!=undefined){
		UserService.getUser().then(function(response){
			$scope.user=response.data;
		},function(response){
				console.log(response.status)
		})
	}
	$scope.logout=function()
	{
		UserService.logout().then(function(response){
			$cookieStore.remove('userDetails')
		},function(response){
			$scope.error=response.data;
			$location.path('/Login')
		})

}
})


