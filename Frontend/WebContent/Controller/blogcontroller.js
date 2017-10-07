app.controller('BlogController',function($scope,BlogService,$location){
	$scope.addBlog=function(){
		BlogService.createBlog($scope.blog).then(function(response){
			Console.log("right");
			alert('Blog added successfully and waitingfor approval..')
		},function(response){//response.status[401/500]
			$scope.error=response.data
			if(response.status==401)
				$location.path('/Login')
				
		},function(response){
			console.log(response.status);
			console.log(response.message);
			$scope.error=response.data;
			$location.path('/login');
		})
	}	
	
	
	function blogApproved(){
		BlogService.blogApproved() .then (function(response){
			$scope.listOfBlogApproved=response.data
		},function(response){
			if(response.status==401)
				$location.path('/login')
		
		})
	}
	
	
	
	
	function blogWaitingForApproval(){
		BlogService.blogWaitingForApproval().then (function(response){
			$scope.listOfBlogWaitingForApproval=response.data
		},function(response){
			if(response.status==401)
				$location.path('/login')
		})
		}
	blogApproved()
	blogWaitingForApproval()
});
