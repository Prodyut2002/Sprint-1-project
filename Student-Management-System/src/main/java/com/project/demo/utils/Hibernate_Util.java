package com.project.demo.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.protobuf.AbstractMessage.Builder;

public class Hibernate_Util {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.config.xml");
		sessionFactory = cfg.buildSessionFactory();
		return sessionFactory;
		
	}
}
