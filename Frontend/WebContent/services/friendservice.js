/**
 * 
 */
app.factory('FriendService',function($http){
	var friendService={}
	var BASE_URL="http://localhost:8088/Middle"
		friendService.listOfSuggestedUsers = function()
		{
			return $http.get(BASE_URL+"/getSuggestedUsers")
		}
	friendService.sendFriendRequest = function(toId)
	{
		console.log("service  send request")
		return $http.get(BASE_URL+"/friendRequest/"+toId)
	}

	friendService.pendingRequests= function()
	{
		console.log("service pending request");
		return $http.get(BASE_URL+"/pendingRequests")
	}
	friendService.updatePendingRequest= function(request)
	{
		return $http.put(BASE_URL+"/updatePendingRequests",request)
	}
	friendService.listOfFriends=function()
	{
		return $http.get(BASE_URL+"/listOfFriends")
	}
	
	return friendService;
})