app.controller('FriendController',function($scope,$location,FriendService){

	function listOfSuggestedUsers(){
	FriendService.listOfSuggestedUsers().then(function(response){
		$scope.suggestedUsers= response.data;
	},function(response){
		$location.path('/Login')
	})

	}
	function pendingRequests(){
		FriendService.pendingRequests().then(function(response){
			$scope.pendingRequest= response.data;
		},function(response){
			$location.path('/Login')
		})

		}
	$scope.sendFriendRequest=function(toId){
		FriendService.sendFriendRequest(toId).then(function(response){
			alert("SENT Successfully");
			listOfSuggestedUsers()
			$location.path('/SuggestedUsers')
		},function(response){
			$location.path('/Login')
		})

		}
	$scope.updatePendingRequest = function(request,statusValue){
		request.status=statusValue;
		FriendService.updatePendingRequest(request).then(function(response){
			pendingRequests()
			$location.path('/PendingRequests')
		},function(response){
			
		})
	
	}
	function listOfFriends()
	{
		FriendService.listOfFriends().then(function(response){
			$scope.listOfFriends=response.data;
		},function(response){
			
		})
	}
	listOfSuggestedUsers()
	PendingRequests()
	listOfFriends()
})