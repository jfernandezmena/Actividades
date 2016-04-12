package com.indra.formacio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.indra.formacio.model.Customer;
import com.indra.formacio.model.Product;
import com.indra.formacio.model.Sale;

import junit.framework.TestCase;

public class SaleTest extends TestCase {

	public void testInsert(){
		Customer c = new Customer();
		c.setName("Nom client");
		
		Product p = new Product();
		p.setName("Nom producte");
		
		Sale s = new Sale(p,c);
		
		EntityManager manager = Persistence.createEntityManagerFactory("com.indra.formacio").createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(c);
		manager.persist(p);
		manager.persist(s);
		manager.getTransaction().commit();
		
		List res = manager.createQuery(
		        "FROM Sale s where s.customer.name = :custName")
		        .setParameter("custName", "Nom client")
		        .getResultList();
		
		assertFalse(res.isEmpty());
		
		Sale sAux = (Sale) res.get(0);
		assertNotNull(sAux);
		assertEquals(s.getCustomer().getName(), c.getName());
		assertEquals(s.getProduct().getName(), p.getName());
		
	}
	
}
