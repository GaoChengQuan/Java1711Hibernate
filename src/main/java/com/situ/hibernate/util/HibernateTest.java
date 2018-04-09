package com.situ.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.situ.hibernate.entity.Student;

public class HibernateTest {
	
	@Test
	public void test1() {
		//O对象
		Student student = new Student();
		student.setName("张三");
		student.setAge(18);
		//获取加载配置文件的管理类对象Configuration
		Configuration configuration = new Configuration();
		configuration.configure();//默认 加载src/hibernate.cfg.xml
		//创建Session的工厂对象
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//创建Session（代表一个回话，与数据库连接的回话）
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();//tx
		//保存对象到数据库
		session.save(student);
		//提交事务
		transaction.commit();
		//关闭session
		session.close();
	}
	
	@Test
	public void test2() {
		//获取加载配置文件的管理类对象Configuration
		Configuration configuration = new Configuration();
		configuration.configure();//默认 加载src/hibernate.cfg.xml
		//创建Session的工厂对象
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//创建Session（代表一个回话，与数据库连接的回话）
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();//tx
		Student student = session.get(Student.class, 5);
		System.out.println(student);
		//提交事务
		transaction.commit();
		//关闭session
		session.close();
	}
}
