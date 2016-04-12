package com.indra.formacio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Employee;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
		Employee emp = new Employee();
		emp.setName("Empleat 1");
		emp.setSurname("Cognom 1");

		Customer c;
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(emp);
		
		
		for (int i = 0; i < 5; i++){
			c = new Customer();
			c.setName("Nom client "+i);
			c.setSurname("Cognom client "+i);
			c.setEmployee(emp);
			manager.persist(c);
		}
		manager.getTransaction().commit();
		
		manager.refresh(emp);

//		List res = manager.createQuery(
//		        "FROM Customer c where c.employee.name = :empName").
//				setParameter("empName", "Empleat 1")
//		        .getResultList();
		
		
		List<Customer> clients = emp.getCustomers();
		
		System.out.println("L'empleat "+emp.getName()+" té els següents clients");
		
		for (Customer customer : clients) {
			System.out.println(customer.toString());
		}
    	
		
		//Secció de vendes

		Product p;
		Sale s;
		
		manager.getTransaction().begin();
		p = new Product();
		p.setName("Producte estàndard");
		manager.persist(p);
		
		for (Customer customer : clients) {
			s = new Sale(p,customer);
			manager.persist(s);
		}
		manager.getTransaction().commit();
		
		List res = manager.createQuery(
		        "FROM Sale s")
		        .getResultList();
		
		Sale salAux;
		
		System.out.println("Vendes de l'empresa");
		for (Object object : res) {
			salAux = (Sale)object;
			System.out.println("Venda: producte "+salAux.getProduct().getName() + " i client "+salAux.getCustomer());
			
		}
		
		
    }
}
