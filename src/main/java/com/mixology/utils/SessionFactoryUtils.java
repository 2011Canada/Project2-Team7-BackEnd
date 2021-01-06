package com.mixology.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionFactoryUtils {
	
	//static reference to the only instance
	private static SessionFactory sf;
	
	//instead of using the constructor
	//we are going to use a static block of code to build this instance
	static {
		Configuration c = new Configuration().configure();//reads in xml file and set initial properties
		
		c.setProperty("hibernate.connection.username", System.getenv("BEAR_USERNAME"));
		c.setProperty("hibernate.connection.password", System.getenv("BEAR_PASSWORD"));
		c.setProperty("hibernate.connection.url", "jdbc:postgresql://" 
													+ System.getenv("BEAR_HOST") 
													+ ":" + System.getenv("BEAR_PORT") 
													+ "/" + System.getenv("BEAR_DBNAME"));
		c.setProperty("hibernate.default.schema", System.getenv("BEAR_SCHEMA"));
		
		//hibernate standardized how sessionFactories were made through a build chain that utilizes something called a service registry
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
		
		sf = c.buildSessionFactory(sr);
	}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}

}
