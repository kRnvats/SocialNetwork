package com.niit.Backend.Dao;

import com.niit.Backend.Model.UploadFile;

public interface UploadFileDao {

	 boolean save(UploadFile uploadFile);

	UploadFile getFile(String userName);
}