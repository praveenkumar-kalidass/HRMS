package com.i2i.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.model.Designation;
import com.i2i.Util.FileUtil;
import com.i2i.connection.HibernateConnection;
import com.i2i.exception.DataException;


/**
 * <p>
 * DataAccessObject(Dao) for Designation model 
 * is used to insert, update and delete designation from department
 * Creates session and transaction objects for each operation 
 * </p>
 * 
 * @author Praveen RaJ
 * 
 * @created 2016-09-01
 */

public class DesignationDao {

	Designation designation = new Designation();
	HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	SessionFactory sessionFactory = hibernateConnection.establishConnection();
	
	public void insertDesignation(Designation designation) throws DataException {
		Session session=sessionFactory.openSession();
		try {
			Transaction transaction=session.beginTransaction();	
	        session.save(designation);  	
	        transaction.commit();   
		} catch (HibernateException ex) {
			FileUtil.ErrorLogger("Error on DesignationDao insertDesignation() : " + ex.toString());
	        throw new DataException("Error Occured while Adding this" + designation.getName() + " : please verify your details... Any try again..!");
		}
	}
	
}
