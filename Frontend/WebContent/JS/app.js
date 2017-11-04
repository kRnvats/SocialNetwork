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
			templateUrl:'Views/CreateBlog.html',
			controller:'BlogController'
		})
		.when('/getAllBlogs',{
			templateUrl:'Views/GetBlog.html',
			controller:'BlogController'
		})
		.when('/getBlogById/:id',{
			templateUrl:'Views/BlogDetails.html',
			controller:'BlogDetailController'
		})
		.when('/getApproval/:id',{
			templateUrl:'Views/ApproveBlog.html',
			controller:'BlogDetailController'
		})
		.when('/Job',{
			templateUrl:'Views/Job.html',
			controller :'JobController'
		})
		.when('/getAllJobs',{
			templateUrl:'Views/GetAllJobs.html',
			controller:'JobController'
		})
		.when('/uploadProfilePicture',{
			templateUrl:'Views/uploadprofilepicture.html',
			
		})
		.when('/pendingRequests',{
			templateUrl:'Views/PendingRequest.html',
			controller:'FriendController'
		})
		.when('/getSuggestedUsers',{
			templateUrl:'Views/SuggestedUser.html',
			controller:'FriendController'
			
		})
		.when('/Friends',{
			templateUrl:'Views/Friends.html',
			controller:'FriendController'
		})
	.otherwise({
		templateUrl:'Views/Home.html'
	})


})
app.run(function($rootScope,$cookieStore,UserService,$location){
	if ($rootScope.currentUser==undefined)
		{
		$rootScope.currentUser=$cookieStore.get('userDetails')
		console.log('hello'+ $cookieStore.get('userDetails'));
		}
})
	
//		$rootScope.logout=function(){
//	delete $rootScope.currentUser;
//
//		UserService.logout().then (function(response){
//			$cookieStore.remove('userDetails')
//			$location.path('/Login')
//		},function(response){
//			console.log(response.status)
//		})
//	}
//});