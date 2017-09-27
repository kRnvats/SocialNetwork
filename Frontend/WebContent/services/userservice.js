/**
* UserService is to make server side calls.
*/
app.factory('UserService',function($http){
	var userService={}
	var BASE_URL="http://localhost:8087/Middle"
		
	
	userService.registerUser=function(){
		$http.post(BASE_URL+"/registeruser",user)
		
	}
	userService.login=function(user){
		return $http.post(BASE_URL+"/login",user)
}
	return userService;
	
})