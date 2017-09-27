package com.niit.Backend.Dao;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.Backend.Model.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

@Autowired
private SessionFactory sessionFactory;
	public boolean registerUser(User user){
		Session session=sessionFactory.getCurrentSession();
		try{
			session.save(user);
			return true;
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			return false;

	}
	}
		public User login(User user){
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where firstname=? and password=?");
			query.setString(0,user.getFirstName());
			query.setString(1,user.getPassword());
			
			return (User)query.uniqueResult();
			
		}
	
	public boolean isEmailValid(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isUsernameValid(String username) {
		// TODO Auto-generated method stub
		return false;
	}
}
