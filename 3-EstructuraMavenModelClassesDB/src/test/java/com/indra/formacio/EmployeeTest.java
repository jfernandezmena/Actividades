package com.indra.formacio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;

import junit.framework.TestCase;

public class EmployeeTest extends TestCase {
	
	public static final int NUMERO_CLIENTS = 2;
	
	public void testInserts(){
		Employee emp = new Employee();
		emp.setName("Empleat 1");
		emp.setSurname("Cognom 1");
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(emp);
		manager.getTransaction().commit();
		
		Customer c;
		
		manager.getTransaction().begin();
		for (int i = 0; i < NUMERO_CLIENTS; i++){
			c = new Customer();
			c.setName("Nom client "+i);
			c.setSurname("Cognom client "+i);
			c.setEmployee(emp);
			manager.persist(c);
		}
		manager.getTransaction().commit();
		
		manager.refresh(emp);
		
		assertEquals(NUMERO_CLIENTS, emp.getCustomers().size());
		
		
	}

}
