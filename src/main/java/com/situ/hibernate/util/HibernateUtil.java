package com.situ.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	
	static {
		// 获取加载配置文件的管理类对象Configuration
		Configuration configuration = new Configuration();
		configuration.configure();// 默认 加载src/hibernate.cfg.xml
		// 创建Session的工厂对象
		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session openSession() {
		// 创建Session（代表一个回话，与数据库连接的回话）
		Session session = sessionFactory.openSession();
		return session;
	}
}
