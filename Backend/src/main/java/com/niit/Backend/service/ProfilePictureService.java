package com.niit.Backend.service;

import com.niit.Backend.Model.ProfilePicture;

public interface ProfilePictureService {

	void uploadProfilePicture(ProfilePicture profilePicture);
	ProfilePicture viewProfilePicture(String userName);
}