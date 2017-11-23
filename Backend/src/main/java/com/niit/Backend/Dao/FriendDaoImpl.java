package com.niit.Backend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.Model.Friend;
import com.niit.Backend.Model.User;

@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<User> listOfSuggestedUsers(String userName) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		SQLQuery query = session.createSQLQuery("select * from user_table where firstName in"
				+"(select firstName from user_table where firstName!=? minus"
				+"(select fromId from friend where toId=?"
				+"union select toId from friend where fromId=?"
				+"))");
				query.setString(0,userName );
				query.setString(1,userName );
				query.setString(2,userName );
				query.addEntity(User.class);
				List<User> suggestedUser = query.list();
				return suggestedUser;

	}
	public void friendRequest(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		session.save(friend);
		
	}
	public List<Friend> pendingRequests(String toID) {
		System.out.println("dao impl friend"+toID);
		char s='P';
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Friend where toId=? and status=?");
		query.setParameter(0, toID);
		query.setParameter(1,s);
		List<Friend> list =query.list();
		for(Friend f:list)
		{
			System.out.println("from"+f.getFromId());
			System.out.println(f.getId());
		}
		return list;
	}
	public void updatePendingRequest(Friend friend) {
		Session s = sessionFactory.getCurrentSession();
		if(friend.getStatus()=='A'){
		s.update(friend);
		}
		else
			s.delete(friend);
	}
	public List<String> listOfFriends(String userName) {
		Session session= sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		SQLQuery query1 = session.createSQLQuery("select fromId from Friend where toId=? and status='A'")
				.addScalar("fromId", StandardBasicTypes.STRING);
				query1.setString(0, userName);
		List<String> list = query1.list();
		System.out.println(list);
		Query query2 = session.createSQLQuery("select toId from Friend where fromId=? and status='A'")
				.addScalar("toId",StandardBasicTypes.STRING);
		query2.setString(0, userName);

		List<String> list1 = query2.list();
		System.out.println(list1);
		list1.addAll(list);
		return list1;
	}
}
