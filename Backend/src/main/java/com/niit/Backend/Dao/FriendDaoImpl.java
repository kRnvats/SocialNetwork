package com.niit.Backend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.Model.Friend;
@Repository("FriendDao")
@Transactional

public class FriendDaoImpl implements FriendDao {

	@Autowired
	SessionFactory sessionFactory;
	{this.sessionFactory = sessionFactory;
	
	}
	
	@Transactional
	public boolean addFriend(Friend friend) 
	{
		try
		{
			friend.addfriend("A");
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
			}
	}

	public Friend getFriend(int friendId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Friend> getFriend() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approverFriend(Friend friend) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean editFriend(int friendId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteFriend(int friendId) {
		// TODO Auto-generated method stub
		return false;
	}
}