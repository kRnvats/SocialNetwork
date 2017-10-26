package com.niit.Backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Backend.Dao.ProfilePictureDao;
import com.niit.Backend.Model.ProfilePicture;

@Service
public class ProfilePictureServiceImpl implements ProfilePictureService {

	@Autowired
	ProfilePictureDao  profilePictureDao;
	public void uploadProfilePicture(ProfilePicture profilePicture) {
			profilePictureDao.uploadProfilePicture(profilePicture);
		
		
	}
	public ProfilePicture viewProfilePicture(String userName) {
		return profilePictureDao.viewProfilePicture(userName);
	}
}