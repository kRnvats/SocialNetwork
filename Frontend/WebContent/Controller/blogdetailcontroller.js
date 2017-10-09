/**
 * 
 */
app.controller('BlogDetailController',function($scope,BlogService,$location,$routeParams){
	var id=$routeParams.id;
	BlogService.getBlogById(id).then(function(response){
		$scope.blog = response.data
	},function(response){
		$location.path('/Login')
		
	})
})