package com.indra.formacio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Objects of this class represents a Customer
 * A Customer has one Employee assigned.
 * @author ealcalal
 *
 */
@Entity
public class Customer {
	@Id
    @GeneratedValue
	protected Long id;
	@Column 
	protected String name;
	@Column
	protected String surname;
	@Column
	protected Float percentProduct;
	@Column
	protected Date percentDate;

	
	//Este atributo que sigue está relacionado con el OneToMany de Employee. Si no definimos esto aquí
	//en la otra clase va a dar error en intentar mapear el OneToMany
	@ManyToOne
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
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Float getPercentProduct() {
		return percentProduct;
	}
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
	
	@Override
	public String toString() {
		return name + " "+surname;
	}
}
