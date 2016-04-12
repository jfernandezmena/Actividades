package com.indra.formacio;

import com.indra.formacio.model.Enterprise;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
        
    	Enterprise ent = new Enterprise();
    	
    	ent.initialize(new Integer [][] {{1,2},{3,4},{5,6,7,8}});
    	ent.calcularPorcentajeEmpleados();
    	ent.calcularPorcentajeClientes();
    	ent.imprimirArrays();
    	//Vuestro código para pintar
        
    	}
    

	}