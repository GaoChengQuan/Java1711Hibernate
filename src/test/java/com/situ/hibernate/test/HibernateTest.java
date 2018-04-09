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

}
