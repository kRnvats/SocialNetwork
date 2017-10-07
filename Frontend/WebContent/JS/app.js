/**
*Angular JS Module
*/
var app=angular.module("app",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	$routeProvider
	.when('/Register',{
		templateUrl:'Views/Register.html',
		controller:'UserController'
	})
	.when('/Home',{
		templateUrl:'Views/Home.html'
	})
		.when('/Login',{
		templateUrl:'Views/Login.html',
			controller:'UserController'
		})
		.when('/EditProfile',{
		templateUrl:'Views/EditProfile.html',
			controller:'UserController'
		})
		.when('/createBlog',{
			templateUrl:'views/CreateBlog.html',
			controller:'BlogController'
		})
		.when('/getAllBlog',{
			templateUrl:'views/getBlogs.html',
			controller:'BlogController'
		})
		.when('/getBlogById/:id',{
			templateUrl:'views/blogdetails.html',
			controller:'BlogDetailController'
		})
		.when('/getApprovalForm/:id',{
			templateUrl:'views/approvalBlogForm.html',
			controller:'BlogDetailController'
		})
	.otherwise({
		templateUrl:'Views/Home.html'
	})


})
app.run(function($rootScope,$cookieStore,UserService,$location){
	if ($rootScope.currentUser==undefined)
		$rootScope.currentUser=$cookieStore.get('userDetails')
		$rootScope.logout=function(){
		delete $rootScope.currentUser;

		UserService.logout().then (function(response){
			$cookieStore.remove('userDetails')
			$location.path('/Login')
		},function(response){
			console.log(response.status)
		})
	}
})








