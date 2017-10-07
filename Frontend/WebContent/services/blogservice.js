app.factory('BlogService',function($http){
	var blogPostService={}
var BASE_URL="http://localhost:8087/Middle"
blogService.addBlog=function(blog){
		
		return $http.post(BASE_URL+"/addblog",blog)
			
		}
	blogService.blogWaitingForApproval = function()	

{

	return $http.get(BASE_URL+"/getAllBlogs/"+0);
}

blogService.blogApproved = function()
{

	return $http.get(BASE_URL+"/getAllBlogs/"+1);
}

blogService.getBlogById = function(id){

	return $http.get(BASE_URL+"/getBlog/"+id)

}
	return blogService;
})