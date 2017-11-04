/**
 * 
 */
app.factory('JobService',function($http){
	
	var jobService ={}
	var BASE_URL ="http://localhost:8087/Middle"
		
	jobService.addJob = function(job)
	{
		return $http.post(BASE_URL+"/Job",job)
	}
	jobService.getAllJobs = function()
	{
		return $http.get(BASE_URL+"/getAllJobs")
	}
	jobService.deleteJob = function(id)
	{
		console.log(id)
		
		return $http.delete(BASE_URL+"/deleteJob/"+id)
		
	}
	
	return jobService;
})
