package com.situ.hibernate.test;

import java.util.Arrays;
import java.util.List;

import javax.swing.text.TabableView;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.situ.hibernate.entity.Student;
import com.situ.hibernate.util.HibernateUtil;

public class HQLQueryTest {
	// 1、基本查询
	@Test
	public void test1() {
		// 1.HQL语句
		String hql = "from Student";// select * from student;
		// 2.得到session
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		// 3.根据查询对象获得结果
		List list = query.list();
		for (Object object : list) {
			System.out.println(object);
		}
		transaction.commit();
		session.close();
	}

	// 2、条件查询
	@Test
	public void test2() {
		// 1.HQL语句
		String hql = "from Student where id=?";
		// 2.得到session
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		// 3.设置参数
		query.setParameter(0, 5);
		// 3.根据查询对象获得结果
		/*
		 * List list = query.list(); for (Object object : list) {
		 * System.out.println(object); }
		 */
		Student student = (Student) query.uniqueResult();
		System.out.println(student);
		transaction.commit();
		session.close();
	}

	// 3、分页查询
	@Test
	public void test3() {
		// 1.HQL语句
		String hql = "from Student";
		// 2.得到session
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		// 3.设置分页信息 limit ?,?
		query.setFirstResult(2);
		query.setMaxResults(2);
		// 4.根据查询对象获得结果
		List list = query.list();
		for (Object object : list) {
			System.out.println(object);
		}
		transaction.commit();
		session.close();
	}

	// 排序
	@Test
	public void test4() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		// String hql = "from Student order by id asc";
		String hql = "from Student order by id desc";
		Query query = session.createQuery(hql);
		List list = query.list();
		for (Object object : list) {
			System.out.println(object);
		}
		transaction.commit();
		session.close();
	}

	// 统计
	@Test
	public void test5() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		String hql1 = "select count(*) from Student";
		String hql2 = "select sum(id) from Student";
		String hql3 = "select avg(id) from Student";
		String hql4 = "select max(id) from Student";
		Query query = session.createQuery(hql4);
		// java.lang.ClassCastException: java.lang.Long cannot be cast to
		// java.lang.Integer
		// Integer count = (Integer) query.uniqueResult();
		// Long count = (Long) query.uniqueResult();
		Number count = (Number) query.uniqueResult();
		System.out.println(count);

		transaction.commit();
		session.close();
	}

	// 投影查询
	@Test
	public void test6() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select id,name from Student";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}

		transaction.commit();
		session.close();
	}

	// 投影查询
	@Test
	public void test7() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select new Student(id,name) from Student";
		Query query = session.createQuery(hql);
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student);
		}

		transaction.commit();
		session.close();
	}
}
