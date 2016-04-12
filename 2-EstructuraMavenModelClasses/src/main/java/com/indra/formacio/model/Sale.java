package com.indra.formacio.model;

import java.util.Date;

public class Sale {
	protected Product product;
	protected Customer customer;
	protected Date saleDate;
	
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
	
}
