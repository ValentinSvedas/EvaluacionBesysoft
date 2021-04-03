package main;

import filtros.Criterio;
import filtros.CriterioAnd;
import filtros.CriterioCategoria;
import filtros.CriterioCodigo;
import tienda.Producto;
import tienda.Vendedor;

public class Main {
	
	public static void main(String args[]) {
		Producto p1 = new Producto(1, "Heladera", 30000, "Electrodomesticos");
		Producto p2 = new Producto(2, "Sillon", 10000, "Muebles");
		Producto p3 = new Producto(3, "Remera", 1500, "Prendas");
		Producto p4 = new Producto(4, "Maquina corta pasto", 7800, "Jardinería");
		Producto p5 = new Producto(5, "Maquina a", 2222, "Jardinería");
		Producto p6 = new Producto(6, "Maquina d", 3333, "Jardinería");
		
		Vendedor v1 = new Vendedor(1, "Juan", 30000);
		v1.agregarProducto(p1);
		v1.agregarProducto(p2);
		v1.agregarProducto(p3);
		v1.agregarProducto(p4);
		v1.agregarProducto(p5);
		v1.agregarProducto(p6);
		
		
	
		Criterio c1 = new CriterioCategoria("Jardinería");
		Criterio c2 = new CriterioCodigo(4);
		Criterio c3 = new CriterioAnd(c1,c2);
		
		System.out.println(v1.buscarProductos(c3));
		
		v1.venderProducto(p1);
		v1.venderProducto(p2);
		
		System.out.println(v1.calcularComision());
		
	}

}
