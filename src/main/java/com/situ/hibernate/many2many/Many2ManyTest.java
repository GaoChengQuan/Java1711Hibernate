package com.situ.hibernate.many2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.situ.hibernate.util.HibernateUtil;

public class Many2ManyTest {
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();

		Banji banji1 = new Banji();
		banji1.setName("java18011");
		Banji banji2 = new Banji();
		banji2.setName("java18022");
		Course course1 = new Course();
		course1.setName("数据库1");
		Course course2 = new Course();
		course2.setName("操作系统1");
		// 表达关系
		banji1.getCourses().add(course1);
		banji1.getCourses().add(course2);
		banji2.getCourses().add(course2);

		session.save(banji1);
		session.save(banji2);
		session.save(course1);
		session.save(course2);

		tx.commit();
		session.close();
	}
	
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();

		Banji banji1 = new Banji();
		banji1.setName("java180111");
		Banji banji2 = new Banji();
		banji2.setName("java180222");
		Course course1 = new Course();
		course1.setName("数据库11");
		Course course2 = new Course();
		course2.setName("操作系统12");
		// 表达关系
		banji1.getCourses().add(course1);
		banji1.getCourses().add(course2);
		banji2.getCourses().add(course2);
		course1.getBanjis().add(banji1);
		course2.getBanjis().add(banji1);
		course2.getBanjis().add(banji2);

		session.save(banji1);
		session.save(banji2);
		session.save(course1);
		session.save(course2);

		tx.commit();
		session.close();
	}

	//将course1和course2从banji1选的课程里面移除
	@Test
	public void test23() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Banji banji = session.get(Banji.class, 15);
		Course course1 = session.get(Course.class, 9);
		Course course2 = session.get(Course.class, 10);
		//将course1和course2从banji1选的课程里面移除
		banji.getCourses().remove(course1);
		banji.getCourses().remove(course2);

		tx.commit();
		session.close();
	}
}
