package com.cgs.pro94tek.healthcare.dataaccess.dao.support;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomHibernateDaoSupport {

   @Autowired
   private SessionFactory sessionFactory;

   public Session getSession () {
	   
      Session session = sessionFactory.getCurrentSession();

      return session;
   }
}
