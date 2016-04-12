package com.indra.formacio.model;

import java.util.Date;

/**
 * Objects of this class represents a Customer
 * A Customer has one Employee assigned.
 * @author ealcalal
 *
 */
public class Customer {
	protected Long id;
	protected String name;
	protected String surname;
	protected Float percentProduct;
	protected Date percentDate;
	protected Employee employee;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getWholeName(){
		return surname +", "+name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname.toUpperCase();
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Float getPercentProduct() {
		return percentProduct;
	}
	
	/**
	 * Método que permite setear el porcentaje de productos que compra un cliente
	 * @param percentProduct Porcentaje de productos, entre 0 y 100
	 */
	public void setPercentProduct(Float percentProduct) {
		this.percentProduct = percentProduct;
	}
	public Date getPercentDate() {
		return percentDate;
	}
	public void setPercentDate(Date percentDate) {
		this.percentDate = percentDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
