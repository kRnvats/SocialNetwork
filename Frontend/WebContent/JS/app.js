/**
*Angular JS Module
*/
var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	$routeProvider
	.when('/register',{
		templateUrl:'views/registrationform.html',
		controller:'UserController'
	})
	.when('/home',{
		templateUrl:'views/home.html'
	})
		.when('/login',{
		templateUrl:'views/login.html',
			controller:'UserController'
		})
		.when('/editprofile',{
		templateUrl:'views/editprofile.html',
			controller:'UserController'
		})
	.otherwise({
		templateUrl:'views/home.html'
	})


})
app.run(function($rootScope,$cookiesStore,UserService){
	if ($rootScope.currentUser==undefined)
		$rootScope.currentUser=$cookiesStore.get('userDetails')
		$rootScope.logout=function(){
		UserService.logout().then (function(response){
			delete $rootScope.currentUser;
			$cookiesStore.remove('userDetails')
			$location.path('/login')
		},function(response){
			console.log(response.status)
		})
	}
})



		