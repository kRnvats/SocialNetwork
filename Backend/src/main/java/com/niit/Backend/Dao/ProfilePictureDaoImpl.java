package com.niit.Backend.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.Model.ProfilePicture;

@Repository("profilePictureDao")
@Transactional
public class ProfilePictureDaoImpl implements ProfilePictureDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void uploadProfilePicture(ProfilePicture profile) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(profile);

		
	}

	public ProfilePicture viewProfilePicture(String userName) {
		Session session = sessionFactory.getCurrentSession();
		ProfilePicture profilePicture =(ProfilePicture)session.get(ProfilePicture.class, userName);
		return profilePicture;
	}

}
