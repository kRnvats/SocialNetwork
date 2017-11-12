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

		.when('/addJob',{
			templateUrl:'Views/addJob.html',
			controller : 'JobController'
		})
		.when('/getAllJobs',{
			templateUrl:'Views/getAllJobs.html',
			controller:'JobController'
		})
		.when('/pendingRequests',{
			templateUrl:'Views/pendingRequest.html',
			controller:'FriendController'
		})
		.when('/getSuggestedUsers',{
			templateUrl:'Views/suggestedusers.html',
			controller:'FriendController'
			
		})
		.when('/listOfFriends',{
			templateUrl:'Views/listoffriends.html',
			controller:'FriendController'
		})
		.when('/chat',{
			templateUrl:'Views/chat.html',
			controller:'ChatController'
		})
	.otherwise({
		templateUrl:'Views/Home.html'
	})


})
app.run(function($rootScope,$cookieStore,UserService,$location){
	if ($rootScope.currentUser==undefined)
		{
		$rootScope.currentUser=$cookieStore.get('userDetails');
		}
	
	




	$rootScope.logout = function()
	{
		$cookieStore.remove('userDetails');
		delete $rootScope.currentUser;
		$location.path('/Login');
		UserService.logout()
		.then(function(response){
	
	
	$scope.error = "Logout out Successfully";
},function(response){
	if(response.status==401)
		{
		
		delete $rootScope.currentUser;
		$cookieStore.remove('userDetails');
		console.log("REMOVE CURRENT USER");

		$location.path('/Login');
		}
})
}
})