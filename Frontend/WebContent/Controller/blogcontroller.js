app.controller('BlogController',function($scope,BlogService,$location){
	$scope.createBlog=function(){
		BlogService.createBlog($scope.blog).then(function(response){
			console.log("right");
			alert('Blog added successfully and waiting for approval..')
		},function(response){//response.status[401/500]
			$scope.error=response.data
			if(response.status==401)
				$location.path('/CreateBlog')
				
		},function(response){
			console.log(response.status);
			console.log(response.message);
			$scope.error=response.data;
			$location.path('/Login');
				
		})
	}	
	
	
	function blogsApproved(){
		BlogService.blogsApproved() .then (function(response){
			$scope.listOfBlogsApproved=response.data
		},function(response){
			if(response.status==401)
				$location.path('/Login')
		
		})
	}
	
	function blogsWaitingForApproval(){
		BlogService.blogsWaitingForApproval().then (function(response){
			$scope.listOfBlogsWaitingForApproval=response.data
		},function(response){
			if(response.status==401)
				$location.path('/Login')
		})
//		}
//	function blogsRejected(){
//		BlogService.blogsRejected().then(function(response){
//			$scope.listOfBlogsRejected=response.data
//		},function(response){
//			$location.path('/Login')
//		
//		})
	}
	blogsApproved()
	blogsWaitingForApproval()
//	blogsRejected()
});







































	