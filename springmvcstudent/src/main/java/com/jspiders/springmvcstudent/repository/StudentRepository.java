package com.jspiders.springmvcstudent.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvcstudent.pojo.StudentPOJO;

@Repository
public class StudentRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private String jpql;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("student");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if(factory != null) {
			factory.close();
		}
		if(manager != null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public StudentPOJO addStudent(String name, Long contact, String address, String course) {
		
		openConnection();
		transaction.begin();
		StudentPOJO student = new StudentPOJO();
		student.setName(name);
		student.setContact(contact);
		student.setAddress(address);
		student.setCourse(course);
		manager.persist(student);
		transaction.commit();
		closeConnection();
		return student;
	}
	
	public StudentPOJO searchStudent(int id) {
		openConnection();
		transaction.begin();
		StudentPOJO student = manager.find(StudentPOJO.class, id);
		transaction.commit();
		closeConnection();
		return student;
	}

	public List<StudentPOJO> searchAllStudents() {
		openConnection();
		transaction.begin();
		jpql = "from StudentPOJO";
		query = manager.createQuery(jpql);
		List<StudentPOJO> student = query.getResultList();
		transaction.commit();
		closeConnection();
		return student;
	}

	public void removeStudent(int id) {
		openConnection();
		transaction.begin();
		StudentPOJO student = manager.find(StudentPOJO.class, id);
		manager.remove(student);
		transaction.commit();
		closeConnection();
	}

	public void updateStudent(int id, String name, long contact, String address, String course) {
		openConnection();
		transaction.begin();
		StudentPOJO student = manager.find(StudentPOJO.class, id);
		student.setName(name);
		student.setContact(contact);
		student.setAddress(address);
		student.setCourse(course);
		manager.persist(student);
		transaction.commit();
		closeConnection();
	}
		
}
