package com.indra.formacio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sale {
	@Id
	@GeneratedValue
	protected int id;
	@OneToOne
	protected Product product;
	@OneToOne
	protected Customer customer;
	@Column
	protected Date saleDate;
	
	public Sale(){
		
	}
	
	public Sale(Product product, Customer customer) {
		this.product = product;
		this.customer = customer;
		this.saleDate = new Date();
	}
	
	public Product getProduct() {
		return product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Date getSaleDate() {
		return saleDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	
}
