/**
* Link2Controller
*/
app.controller('UserController',function($scope,UserService,$location,$rootScope,$cookieStore){

$scope.registerUser=function(){
	console.log("USER DATA IS "+$scope.user);
	UserService.registerUser($scope.user).then(function(response){
	console.log(response.data);
	console.log(response.status);
	$location.path('/Login');
},function(response){
	console.log(response.data);
	console.log(response.status);
	$scope.error=response.data;
	$location.path('/Register');
})
}


$scope.login=function(){
	console.log("User Login Data"+$scope.user);
	UserService.login($scope.user).then(function(response){
		
		$rootScope.currentUser=response.data
		$cookieStore.put('userDetails',response.data);
		
		console.log(response.data);
		console.log(response.status);
		
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

	$scope.updateUser = function(){
		UserService.updateUser($scope.user)
				.then(function(response){
					alert("Updated Successfully");
					$location.path('/Home');
				},function(response){
					if(response.status==401)
					{
					$location.path('/Login')
					}
				else{
					$scope.error = response.data;
				$location.path('/EditProfile')
				}
				})
	}
	$scope.logout=function()
	{
		delete $rootScope.currentUser;
		UserService.logout().then(function(response){
			console.log("CURRENT USER");
			console.log("DELETE CURRENT USER");
			
			$cookieStore.remove('userDetails')
			console.log("REMOVE CURRENT USER");
			$location.path('/Login');
		},function(response){
			if(response.status==401)
				{console.log(response.message);
				delete $rootScope.currentUser;
				console.log(" CURRENT USER");
				console.log("DELETED CURRENT USER");
				$cookieStore.remove('userDetails');
				console.log("REMOVE CURRENT USER");
				
			
			$location.path('/Login')
				}
		})
		}
});


	

	
	
