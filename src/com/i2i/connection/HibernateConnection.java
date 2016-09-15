package com.i2i.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * <p>
 * Hibernate Connection is used to connect the application with database using Hibernate configuration
 * Class is architectured using singleton factory concept.
 * </p>
 *
 * @author Praveen RaJ
 *
 * @created 2016-09-01
 */

public class HibernateConnection {
   
    private static HibernateConnection hibernateConnection = null;
    private AnnotationConfiguration configuration=null;
    private SessionFactory sessionFactory=null;
    
    /**
     * Restricts object creation for this class
     */
    private HibernateConnection(){  
    } 
    
    /**
     * This method is used to create object for this class
     * It doesn't allow to create more then one object
     * and returns the existing object.
     * @return hibernateconnection
     *        Contains object for class HibernateConnection
     */
    public static HibernateConnection createObject() {
        if(hibernateConnection==null){
            hibernateConnection = new HibernateConnection();
        }         
        return hibernateConnection;
    }
    
    /**
     * This Method is used to create object for sessionFactory through "hibernate.cfg.xml" file    
     * It doesn't allow to create more then one object
     * and returns the existing object.     
     * @return sessionFactory
     *        Contains object for class SessionFactory
     */
    public SessionFactory establishConnection() {
        if(configuration==null){
            configuration=new AnnotationConfiguration();
   	        configuration.configure("hibernate.cfg.xml"); 
   	    }
   	    if(sessionFactory==null){	
	        sessionFactory=configuration.configure().buildSessionFactory();
	    }
        return sessionFactory;
   }
 }
