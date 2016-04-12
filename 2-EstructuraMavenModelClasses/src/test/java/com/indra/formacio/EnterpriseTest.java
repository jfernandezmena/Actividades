package com.indra.formacio;

import com.indra.formacio.model.Enterprise;

import junit.framework.TestCase;

public class EnterpriseTest extends TestCase{
	
	public void testInicializa(){
		Integer [][] array = new Integer [][] {{1,2},{3,4}};
		Enterprise ent = new Enterprise();
    	ent.initialize(array);
    	
    	assertEquals(2, ent.getEmpleadosEmpresa().size());
    	//calcular total clientes
    	assertEquals(4,ent.getClientesEmpresa().size());
    	//calcular total productos
    	assertEquals(10,ent.getProductosEmpresa().size());
    	assertEquals("Cliente 0 del empleado 0",
    			ent.getClientesEmpresa().get(0).getName());
	}
	
	public void testCalcularPorcentaje(){
		Integer [][] array = new Integer [][] {{1,2},{3,3,1}};
		Enterprise ent = new Enterprise();
    	ent.initialize(array);
    	
    	ent.calcularPorcentajeEmpleados();
    	ent.calcularPorcentajeClientes();
    	
    	//Comprobar algun porcentaje de empleado
    	assertEquals(3f/5, ent.getEmpleadosEmpresa().get(1).
    			getPercentCustomers());
    	
    	//comprobar algun porcentaje de cliente
    	assertEquals(0.1f, ent.getClientesEmpresa().get(0).
    			getPercentProduct());
	}

}
