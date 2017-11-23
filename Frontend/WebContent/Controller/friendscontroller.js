/**
 * 
 */
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
				console.log("pending request");
				$scope.pendingRequest= response.data;
			},function(response){
				$location.path('/Login')
			})

			}
		$scope.sendFriendRequest=function(toId){
			FriendService.sendFriendRequest(toId).then(function(response){
				alert("SENT Successfully");
				listOfSuggestedUsers()
				$location.path('/getSuggestedUsers')
			},function(response){
				$location.path('/Login')
			})

			}
		$scope.updatePendingRequest = function(request,statusValue){
			request.status=statusValue;
			FriendService.updatePendingRequest(request).then(function(response){
				pendingRequests()
				$location.path('/pendingRequest')
			},function(response){
				
			})
		
		}
		function listOfFriends()
		{
			console.log("list of friends");
			FriendService.listOfFriends().then(function(response){
				$scope.listOfFriends=response.data;
			},function(response){
				
			})
		}
		listOfFriends()
		listOfSuggestedUsers()
		pendingRequests()
	})
	
	