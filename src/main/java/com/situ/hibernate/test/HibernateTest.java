package com.situ.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.situ.hibernate.entity.Student;
import com.situ.hibernate.util.HibernateUtil;

public class HibernateTest {
	
	@Test
	public void test1() {
		//O对象
		Student student = new Student();
		student.setName("张三");
		student.setAge(18);
		Session session = HibernateUtil.openSession();
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
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();//tx
		Student student = session.get(Student.class, 5);
		System.out.println(student);
		//提交事务
		transaction.commit();
		//关闭session
		session.close();
	}
	
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();//tx
		Student student = new Student();
		student.setName("张三");//临时状态
		session.save(student);//有id，在session缓存中有，也保存到数据库，持久化状态
		transaction.commit();
		session.close();//有id，没有session缓存中，数据库中有，游离状态
	}
	
	@Test
	public void test4() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();//tx
		Student student = session.get(Student.class, 1);//持久化状态
		student.setName("李四");
		student.setGender("男");
		//session.update(student);
		transaction.commit();
		session.close();
	}

}
