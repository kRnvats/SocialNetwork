app.factory('FriendService',function($http){
	var friendService={}
	var BASE_URL="http://localhost:8087/Middle"
		
		friendService.listOfSuggestedUsers = function()
		{
			return $http.get(BASE_URL+"/getSuggestedUsers")
		}
	friendService.sendFriendRequest = function(toId)
	{
		return $http.get(BASE_URL+"/friendRequest/"+toId)
	}

	friendService.pendingRequests= function()
	{
		return $http.get(BASE_URL+"/PendingRequests")
	}
	friendService.updatePendingRequest= function(request)
	{
		return $http.put(BASE_URL+"/updatePendingRequests",request)
	}
	friendService.listOfFriends=function()
	{
		return $http.get(BASE_URL+"/Friends")
	}
	return friendService;
})