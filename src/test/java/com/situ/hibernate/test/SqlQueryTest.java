package com.situ.hibernate.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.CreateKeySecondPass;
import org.junit.Test;

import com.situ.hibernate.entity.Student;
import com.situ.hibernate.util.HibernateUtil;

public class SqlQueryTest {
	// 1、基本查询
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "select * from student";
		Query query = session.createSQLQuery(sql);
		//每一行的结果封装到Object[]中,因为列的类型可能不一样，所以用Object
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			/*for (Object object : objects) {
				System.out.println(object);
			}*/
			System.out.println(Arrays.toString(objects));
		}
		
		transaction.commit();
		session.close();
	}
	
	// 1、基本查询
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "select * from student";
		SQLQuery query = session.createSQLQuery(sql);
		//将结果封装到哪个对象
		query.addEntity(Student.class);
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student);
		}
		transaction.commit();
		session.close();
	}
	
	// 2、条件查询
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "select * from student where id=?";
		SQLQuery query = session.createSQLQuery(sql);
		//设置参数
		query.setParameter(0, 5);
		//将结果封装到哪个对象
		query.addEntity(Student.class);
		Student student = (Student) query.uniqueResult();
		System.out.println(student);
		transaction.commit();
		session.close();
	}
	
	// 3、分页查询
	@Test
	public void test43() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "select * from student limit ?,?";
		SQLQuery query = session.createSQLQuery(sql);
		//设置分页信息 limit ?,?
		query.setParameter(0, 2);
		query.setParameter(1, 2);
		//将结果封装到哪个对象
		query.addEntity(Student.class);
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student);
		}
		transaction.commit();
		session.close();
	}
}
