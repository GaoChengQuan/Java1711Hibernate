package com.situ.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.CreateKeySecondPass;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.situ.hibernate.entity.Student;
import com.situ.hibernate.util.HibernateUtil;

public class CriteriaQueryTest {
	// 1、基本查询
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);
		List list = criteria.list();
		System.out.println(list);

		transaction.commit();
		session.close();
	}

	// 2、条件查询
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);
		// 添加查询参数
		// == eq
		// > gt(greater than)
		// >= ge(greater or equals)
		// < lt(less than)
		// <= le
		// != ne
		// in in
		// between and between
		// like like
		// is not null isNotNull
		// is null isNull
		// or or
		// and and

		// criteria.add(Restrictions.eq("id", 5));
		criteria.add(Restrictions.ilike("name", "%三%"));
		// Student student = (Student) criteria.uniqueResult();
		// System.out.println(student);
		List list = criteria.list();
		System.out.println(list);
		transaction.commit();
		session.close();
	}

	// 3、分页查询
	@Test
	public void test3() {
		Session session = HibernateUtil.openSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Student.class);
		//设置分页信息 limit ?,?
		criteria.setFirstResult(2);
		criteria.setMaxResults(2);
		List list = criteria.list();
		System.out.println(list);

		transaction.commit();
		session.close();
	}
}
