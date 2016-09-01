package com.i2i.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * <p>
 * Hibernate Connection is used to connect the application with database using Hibernate configuration
 * Class is architectures by using singleton factory concept
 * </p>
 *
 * @author Praveen RaJ
 *
 * @created 2016-08-10
 */

public class HibernateConnection {
   
	private static HibernateConnection hibernateConnection = null;
    private AnnotationConfiguration configuration=null;
    private SessionFactory sessionFactory=null;
    
    /**
     * Restrict to create object for this class
     */
    private HibernateConnection(){  
    } 
    
    /**
     * HibernateConnection static method is used to create object to the class
     * It doesn't allow to create more then one object. 
     * If try to create object it will returns existing created object     
     * @return hibernateconnection
     *        Contains object for class hibernateConnection
     */
    public static HibernateConnection createObeject() {
        if(hibernateConnection==null){
            hibernateConnection = new HibernateConnection();
        }         
        return hibernateConnection;
    }
    
    /**
     * Method is used to create object for sessionFactory through "hibernate.cfg.xml" file    
     * It doesn't allow to create more then one object. 
     * If try to create object it will returns existing created object     
     * @return sessionFactory
     *        Contains object for class sessionFactory
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