package com.niit.Backend.Dao;


import com.niit.Backend.Model.ProfilePicture;

public interface ProfilePictureDao {

	void uploadProfilePicture(ProfilePicture profile);
	ProfilePicture viewProfilePicture(String userName);
}