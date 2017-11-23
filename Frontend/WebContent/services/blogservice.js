app.factory('BlogService',function($http){
	var blogService={};
var BASE_URL="http://localhost:8088/Middle"
blogService.createBlog=function(blog){
		
		return $http.post(BASE_URL+"/createBlog",blog)
			
		}
	blogService.blogsWaitingForApproval = function()	

{

	return $http.get(BASE_URL+"/getAllBlogs/"+0);
}

blogService.blogsApproved = function()
{

	return $http.get(BASE_URL+"/getAllBlogs/"+1);
}

blogService.getBlogById = function(id){

	return $http.get(BASE_URL+"/getBlog/"+id)

}

blogService.approve = function(blog)
{
	
	return $http.put(BASE_URL+"/approveBlog",blog);
}

blogService.addComment = function(blogComment,id)
{
	return $http.post(BASE_URL+"/addBlogComment/"+id,blogComment)
}
blogService.getBlogComments = function(id)
{
	return $http.get(BASE_URL+"/getBlogComments/"+id)

}
	return blogService;
})




