package com.niit.Backend.Dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.Model.Friend;
import com.niit.Backend.Model.User;


@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {
@Autowired
private SessionFactory sessionFactory;
	public List<User> listOfSuggestedUser(String username){
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query=session.createSQLQuery("select * from user_table where username is"
				+"select username from user_table where username!=? minus"
				+"select FormId from friend_table where ToId=?"
				+"union select ToId from friend_table where FromId=?)"
				+")");
	query.setString(0, username);
	query.setString(1, username);
	query.setString(2, username);
	query.addEntity(User.class);
	List<User> suggestedUser=query.list();
	return suggestedUser;
	}
	public void FriendRequest(Friend friend){
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
	}
	public List<Friend> pendingRequests(String ToId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend whereToId=? and status='p'");
		query.setString(0, ToId);
		return query.list();
		
	
	
	}
	public List<User> listOfSuggestedUsers(String Username) {
		// TODO Auto-generated method stub
		return null;
	}

}
