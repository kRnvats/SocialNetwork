/**
 * 
 */
app.controller('BlogDetailController',function($scope,BlogService,$location,$routeParams){
	$scope.isRejected=false
	var id=$routeParams.id;
	$scope.isLiked=false;
	BlogService.getBlogById(id).then(function(response){
		$scope.blog = response.data
	},function(response){
		$location.path('/Login')
		
	})

	$scope.approve=function()
	{
		console.log($scope.blog.blogStatus);
		
		BlogService.approve($scope.blog).then(function(response){
			
			$location.path('/getAllBlogs')
			alert("Approved")
	},function(response){
		
		console.log(response.data);
		console.log(response.status);
		alert("Error")
		$location.path('/Login');
	})
	}
	$scope.showRejectionTxt=function(val)
	{
		$scope.isRejected=val;
	}
	
	$scope.updateLike = function()
	{
		$scope.isLiked=!$scope.isLiked
		if($scope.isLiked)
			{
				$scope.blog.likes =$scope.blog.likes+1;
			}
		else
			{
			$scope.blog.likes = $scope.blog.likes-1;
			}
		BlogService.approve($scope.blog).then(function(response){
		
		},function(response){
			
		})
	}
	$scope.addComment = function(Id)
	{
		$scope.blogComment.blog = $scope.blog;
		console.log($scope.blogComment.blog);
		BlogService.addComment($scope.blogComment,Id).then(function(response){
			$scope.blogComment.blogCommentText="";
			getBlogComments();
		},function(response){
			$location.path('/getBlogById/'+$scope.blog.blogId)
		})
	}
	
	function getBlogComments()
	{
		BlogService.getBlogComments(id).then(function(response){
			$scope.blogComments = response.data
			console.log($scope.blogComments);
		},function(response){
			$location.path('/getBlogById/'+$scope.blog.blogId)
		})
	}
	
getBlogComments()
	
})



