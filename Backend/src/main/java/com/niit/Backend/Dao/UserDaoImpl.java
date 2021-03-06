package com.niit.Backend.Dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.Backend.Model.User;
@Repository("userDao")
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
	
	public boolean isUsernameValid(String username) {

		 Session session = sessionFactory.getCurrentSession();
		User user =(User)session.get(User.class, username);
		if(user==null)
			return true;
		else
			return false;
}
		public User login(User user){
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where emailId=? and password=?");
			query.setString(0,user.getEmailId());
			query.setString(1,user.getPassword());
			user = (User)query.uniqueResult();
			
			return user;
			
		}
	
		public boolean isEmailValid(String email) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from User where emailID=?");
			query.setString(0, email);
			User user=(User) query.uniqueResult();
			if(user==null)
				return true;
			else
				return false;
		}

		public void update(User user){
			Session session = sessionFactory.getCurrentSession();
			session.update(user);

}
		public User getUserByUserName(String firstName) {
			Session session = sessionFactory.getCurrentSession();
			User user=(User)session.get(User.class, firstName);
			return user;
		}

		public boolean isUpdatedEmailValid(String email,String userName)
		{
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where emailId=? and firstName!=?");
			query.setString(0,email);
			query.setString(1, userName);
			User user = (User)query.uniqueResult();
			if(user==null)
				return true;
			else
				return false;

		}

		@Transactional
		public List<User> getAllUser() {
			System.out.println("Starting getAllUsers DaoImpl");
			String hql = "from User";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			System.out.println("Ending UserDao getAllUser");
			return query.list();
		}
	}




