package com.situ.hibernate.lazyload;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.situ.hibernate.util.HibernateUtil;

public class Many2ManyTest {
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Student student = session.load(Student.class, 1);
		System.out.println("-------------");
		System.out.println(student);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void test2() {
		Student student = new Student(2, "李四");
		System.out.println(student);
	}
	
	@Test
	public void test31() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		Banji banji = session.load(Banji.class, 1);
		System.out.println("-------------");
		Set<Student> students = banji.getStudents();//查询banji下面学生也是懒加载
		System.out.println("*************");
		System.out.println(students.size());
		
		tx.commit();
		session.close();
	}
	
}
