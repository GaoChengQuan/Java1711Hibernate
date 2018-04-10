package com.situ.hibernate.one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.situ.hibernate.util.HibernateUtil;

public class One2ManyTest {
	// 保存班级以及班级对应的学生
	@Test
	public void test1() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();

		Banji banji = new Banji();
		banji.setName("java1707");
		Student student1 = new Student();
		student1.setName("张三1");
		Student student2 = new Student();
		student2.setName("张三2");
		// 表达关系
		// 表达一对多关系：一个班级有多个学生
		banji.getStudents().add(student1);
		banji.getStudents().add(student2);
		// 表达多对一关系：多个学生属于一个班级
		student1.setBanji(banji);
		student2.setBanji(banji);

		session.save(banji);
		session.save(student1);
		session.save(student2);

		tx.commit();
		session.close();
	}

	// 为班级增加学生
	@Test
	public void test2() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();

		Banji banji = session.get(Banji.class, 2);
		Student student = new Student();
		student.setName("张三3");
		//把学生添加到班级里面
		banji.getStudents().add(student);
		student.setBanji(banji);

		session.save(banji);
		session.save(student);

		tx.commit();
		session.close();
	}
}
