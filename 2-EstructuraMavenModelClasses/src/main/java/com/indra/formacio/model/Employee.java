package com.indra.formacio.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Objects of this class represent an Employee
 * 
 * @author ealcalal
 *
 */
public class Employee {
	
	SimpleDateFormat	sdf = new SimpleDateFormat("dd/mm/yyyy");	
	
	protected Long id;
	protected String name;
	protected String surname;
	protected Date birthday;
	protected Float percentCustomers;
	protected Date percentDate;
	
	
//	public Employee (long id, String name, String surname, String birthday){
//		this.id = id;
//		this.name = name;
//		this.surname = surname;
//		//Alerta con el SURROUND!!
//		try {
//			this.birthday = sdf.parse(birthday);
//		} catch (ParseException e) {
//			System.out.println("Error seteando la fecha!!");
//			e.printStackTrace();
//			this.birthday = new Date();
//		}
//	}
	
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getBirthday(Long id){
		return "El empleado "+id+" nació en "+this.birthday;
	}
	public String getBirthday(String nombre) {
		return "El empleado "+ nombre +" nació en " +this.birthday;
	}
	public Float getPercentCustomers() {
		return percentCustomers;
	}
	public void setPercentCustomers(Float percentCustomers) {
		this.percentCustomers = percentCustomers;
	}
	public Date getPercentDate() {
		return percentDate;
	}
	public void setPercentDate(Date percentDate) {
		this.percentDate = percentDate;
	}
	
	@Override
	public String toString() {
		return name + " " + surname;
	}
	
}
