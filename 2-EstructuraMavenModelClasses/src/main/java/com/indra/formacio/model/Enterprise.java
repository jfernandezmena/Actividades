package com.indra.formacio.model;

import java.util.ArrayList;

public class Enterprise {
	
	private ArrayList<Employee> empleadosEmpresa;
	private ArrayList<Customer> clientesEmpresa;
	private ArrayList<Product> productosEmpresa;
	private ArrayList<Sale> ventasEmpresa;
	
	public Enterprise(){
		this.empleadosEmpresa = new ArrayList<Employee>();
		this.clientesEmpresa = new ArrayList<Customer>();
		this.productosEmpresa = new ArrayList<Product>();
		this.ventasEmpresa = new ArrayList<Sale>();		
	}
	
	

	public Enterprise(ArrayList<Employee> empleadosEmpresa, ArrayList<Customer> clientesEmpresa,
			ArrayList<Product> productosEmpresa, ArrayList<Sale> ventasEmpresa) {
		this.empleadosEmpresa = empleadosEmpresa;
		this.clientesEmpresa = clientesEmpresa;
		this.productosEmpresa = productosEmpresa;
		this.ventasEmpresa = ventasEmpresa;
	}



	public ArrayList<Employee> getEmpleadosEmpresa() {
		return empleadosEmpresa;
	}

	public void setEmpleadosEmpresa(ArrayList<Employee> empleadosEmpresa) {
		this.empleadosEmpresa = empleadosEmpresa;
	}

	public ArrayList<Customer> getClientesEmpresa() {
		return clientesEmpresa;
	}

	public void setClientesEmpresa(ArrayList<Customer> clientesEmpresa) {
		this.clientesEmpresa = clientesEmpresa;
	}

	public ArrayList<Product> getProductosEmpresa() {
		return productosEmpresa;
	}

	public void setProductosEmpresa(ArrayList<Product> productosEmpresa) {
		this.productosEmpresa = productosEmpresa;
	}

	public ArrayList<Sale> getVentasEmpresa() {
		return ventasEmpresa;
	}

	public void setVentasEmpresa(ArrayList<Sale> ventasEmpresa) {
		this.ventasEmpresa = ventasEmpresa;
	}

    public void initialize(Integer [][] empCliProd){
    	
    	Employee e;
    	Customer c;
    	int numProduct;
    	Product p;
    	Sale s;
    	
    	for (int i = 0; i < empCliProd.length; i++) {
			e = new Employee();
			e.setId(new Long(i));
			e.setName("Empleado "+i);
			empleadosEmpresa.add(e);
			for (int j = 0; j < empCliProd[i].length; j++) {
				c = new Customer();
				c.setId(new Long(j));
				c.setName("Cliente " +j+ " del empleado "+i);
				c.setEmployee(e);
				clientesEmpresa.add(c);
				numProduct = empCliProd[i][j];
				for (int k = 0; k < numProduct; k++) {
					p = new Product();
					p.setId(new Long(k));
					p.setName("Producto " +k + " del "+c.getName());
					productosEmpresa.add(p);
					s = new Sale(p,c);
					ventasEmpresa.add(s);
				}
			}
		} 	
    	
    }
    
    public  void calcularPorcentajeEmpleados(){
    	ArrayList<Employee> referencias = new ArrayList<Employee>();
    	int cont = 0;
    	int totalClientes = clientesEmpresa.size();
    	for(int j = 0; j< empleadosEmpresa.size();j++){
    		for (int i = 0; i < clientesEmpresa.size(); i++) {
        		if(clientesEmpresa.get(i).getEmployee().getId() ==
        				empleadosEmpresa.get(j).getId()){
        			cont++;
        		}
        	}
    		empleadosEmpresa.get(j).setPercentCustomers((float)
    				cont/totalClientes);
    		cont = 0;
    	}
    	
    }
    
    public  void calcularPorcentajeClientes(){
    	int cont  = 0;
    	int totalProductos = productosEmpresa.size();
    	//Objeto sale tiene objetos producto y customer
    	for(int j = 0; j < clientesEmpresa.size();j++){
    		for (int i = 0; i < ventasEmpresa.size(); i++) {
    			if(clientesEmpresa.get(j).getId() == 
    				ventasEmpresa.get(i).getCustomer().getId()){
    				cont++;
    			}
    		}
    		clientesEmpresa.get(j).setPercentProduct((float)
    				cont/totalProductos);
    	}
    }
    
    public   void imprimirArrays(){
    	for (int i = 0; i < empleadosEmpresa.size(); i++) {
			System.out.println("-"+empleadosEmpresa.get(i).getName());
			System.out.println("-Porcentaje de clientes: " + 
			empleadosEmpresa.get(i).getPercentCustomers());
			System.out.println("-Clientes: ");
			for(int j = 0; j < clientesEmpresa.size();j++){
				if(empleadosEmpresa.get(i).getId() == 
					clientesEmpresa.get(j).getEmployee().getId()){
					System.out.println("\t-"+clientesEmpresa.get(j).getName() +
							", Porcentaje de productos: " + 
							clientesEmpresa.get(j).getPercentProduct());
					for(int k = 0; k <ventasEmpresa.size();k++){
						if(ventasEmpresa.get(k).getCustomer().getId() ==
								clientesEmpresa.get(j).getId()){
							System.out.println("\t\t-"+ventasEmpresa.get(k).
									getProduct().getName());
						}
					}
				}
			}
		}
    	
    }
	
	
}
