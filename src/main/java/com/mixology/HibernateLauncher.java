package com.mixology;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mixology.utils.SessionFactoryUtils;

public class HibernateLauncher {
	
	Session sess = SessionFactoryUtils.getSessionFactory().openSession();
	Transaction t = sess.beginTransaction();
	

	
//	sess.save(object);
//	t.commit();
//	sess.close();

}
