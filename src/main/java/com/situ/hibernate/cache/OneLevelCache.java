package com.situ.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.situ.hibernate.entity.Student;
import com.situ.hibernate.util.HibernateUtil;

public class OneLevelCache {

	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();// tx
		Student student1 = session.get(Student.class, 1);
		Student student2 = session.get(Student.class, 1);
		Student student3 = session.get(Student.class, 1);
		Student student4 = session.get(Student.class, 1);
		System.out.println(student1 == student2);
		System.out.println(student3 == student4);
		// 提交事务
		transaction.commit();
		// 关闭session
		session.close();
	}
	
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();// tx
		Student student1 = session.get(Student.class, 1);
		student1.setName("王五88888");
		session.update(student1);
		student1.setName("赵六8888");
		session.update(student1);
		// 提交事务
		transaction.commit();
		// 关闭session
		session.close();
	}
	
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();// tx
		Student student = new Student();
	    student.setId(77);//游离状态
	    student.setName("李四6666");
	    session.update(student);
	    student.setName("李四7777");
	    session.update(student);
		// 提交事务
		transaction.commit();
		// 关闭session
		session.close();
	}
}
