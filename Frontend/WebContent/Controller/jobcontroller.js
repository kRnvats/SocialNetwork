/**
 * 
 */
app.controller('JobController',function($scope,JobService,$location,$routeParams){
	var self = this;
	
//	var id = $routeParams.id;
	self.job = 
			{'jobTitle':'',
			 'location':'',
			 'companyName':'',
			 'workExperience':'',
			 'skillsRequired':'',
			 'salary':'',
			 'jobDesc':''};
	
	
	self.submit = function()
	{
		
	{
		console.log("submit is clicked");
		self.addJob(self.job);
		
	}
	self.reset();
};
	self.reset = function()
	{
		self.job = 
		{'jobTitle':'',
		 'location':'',
		 'companyName':'',
		 'workExperience':'',
		 'skillsRequired':'',
		 'salary':'',
		 'jobDesc':''};
	}
	self.addJob = function()
	{
		JobService.addJob(self.job).then(function(response){
			console.log("I am here")
			self.job = response.data;
			self.job = ''
				alert("Added")
			$location.path('/getAllJobs')
		},function(response){
			console.log(response.data)
		})
	}
	self.getAllJobs = function()
	{
		JobService.getAllJobs().then(function(response){
			$scope.listOfJobs = response.data;
			console.log($scope.listOfJobs);
			
		},function(response){
			console.log(response.data)
		})
	}
	self.getAllJobs();
	
	$scope.deleteJob = function(id)
	{
		
		JobService.deleteJob(id).then(function(response){
			alert("Deleted")
			getAllJobs();
			$location.path('/getAllJobs')
		},function(response){
			console.log(response.status);
			console.log(response.message);
			$scope.error=response.data;
			$location.path('/Login');
		})
	}
	
});