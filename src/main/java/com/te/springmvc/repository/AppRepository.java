package com.te.springmvc.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.springmvc.entity.Employee;
import com.te.springmvc.entity.dto.EmployeeUpdatedDto;

@Repository
public class AppRepository {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public Employee register(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();

		return employee;
	}

	public Employee findByEmployeeId(int employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);

		return employee;
	}

	public Employee updateEmployee(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}
	
	public boolean deleteEmployeeDetails(int employeeId) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee employee = entityManager.find(Employee.class, employeeId);
		
		entityTransaction.begin();
		entityManager.remove(employee);;
		entityTransaction.commit();
		
		return true;
	}
}
