/**
* UserService is to make server side calls.
*/
app.factory('UserService',function($http){
	var userService={};
	var BASE_URL="http://localhost:8087/Middle"
		
	
	userService.registerUser=function(user){
		return $http.post(BASE_URL+"/RegisterUser",user)
		
		
	}
	userService.login=function(user){
		return $http.post(BASE_URL+"/Login",user)
}
	userService.logout=function(){
		console.log("user logout");
		return $http.put(BASE_URL+"/Logout")
	}
	userService.getUser=function(){
		return $http.get(BASE_URL+"/GetUser")
	}
	userService.updateUser= function(user)
	{
		return $http.put(BASE_URL+"/updateUser",user)
	}
	return userService;
	
})



