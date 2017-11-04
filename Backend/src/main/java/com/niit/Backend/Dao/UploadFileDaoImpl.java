package com.niit.Backend.Dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.Model.UploadFile;



@Repository
@Transactional
public class UploadFileDaoImpl implements UploadFileDao {

	@Autowired
	private SessionFactory sessionFactory;


	public  boolean save(UploadFile uploadFile) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(uploadFile);
		return true;
		

	}

	public UploadFile getFile(String userName) {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UploadFile where userName = ?");
		query.setParameter(0, userName);
		UploadFile uploadFile = (UploadFile) query.uniqueResult();
		
		return uploadFile;

	}

}