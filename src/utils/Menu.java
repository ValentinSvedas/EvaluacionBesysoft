package utils;

import java.util.Scanner;

import tienda.Producto;
import tienda.Vendedor;

public class Menu {	
	
	BBDD bd= new BBDD();
	
	public void menuVentas() {
		Scanner sc = new Scanner(System.in);
		String op = "";
		while(!op.equals("0")) {
			System.out.println("0  Salir");
			System.out.println("1  Agregar vendedor");
			System.out.println("2  Menu vendedor");
			System.out.println("3  Buscar producto");
			System.out.println("4  Mostrar todos los producto");
			System.out.println("5  Mostrar todos los vendedores");
			op = sc.nextLine();
			switch(op) {
				case "0": break;
				case "1": addVendedor(sc);
				break;
				case "2": menuVendedor(sc);
				break;
				case "3": buscarProducto(sc);
				break;
				case "4": showProductos();
				break;
				case "5": showVendedores();
				break;
				default: System.out.println("Opcion no encontrada");
			}
		}
	}
	
	public void addVendedor(Scanner sc) {
		try {
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Sueldo: ");
			int sueldo= sc.nextInt();
			bd.addVendedor(nombre, sueldo);
		}catch(Exception exc){
			System.out.println("No se pudo agregar al vendedor");
		}
	}
	
	public void menuVendedor(Scanner sc) {
		if(bd.showVendedores().size()>0) {
			System.out.println("Elige vendedor para acceder a su menu");
			this.showVendedores();
			int num= sc.nextInt();
			Vendedor v = bd.vendedorN(num-1);
			if(!v.equals(null)) {
				System.out.println("0 - Vender producto");
				System.out.println("1 - Agregar producto");
				System.out.println("2 - Calcular comision");
				int op= sc.nextInt();
				switch(op) {
					case 0: sellProducto(v, sc);
						break;
					case 1: addProducto(v,sc);
						break;
					case 2: System.out.println(v.calcularComision());
				}
				
			}else {
				System.out.println("No se encontro el vendedor");
			}
		}else {
			System.out.println("No existen vendedores");
		}
		
	}
	
	
	public void buscarProducto(Scanner sc) {
		
	}
	public void sellProducto(Vendedor v,Scanner sc) {
		System.out.println(v.getProductos());
		int num= sc.nextInt();
		v.venderProducto(bd.productoN(num));
	}
	public void addProducto(Vendedor v,Scanner sc) { //int codigo, String nombre, int precio, String categoria
		try {
			System.out.print("Nombre: ");
			String nombre = sc.nextLine();
			System.out.print("Categoria: ");
			String categoria = sc.nextLine();
			System.out.print("Precio: ");
			int precio= sc.nextInt();
			Producto p = new Producto(bd.cantidadProductos()+1, nombre, precio, categoria, v);
			v.agregarProducto(p,bd);
		}catch(Exception exc){
			System.out.println("No se pudo agregar el producto");
		}
	}	
	
	public void showVendedores() {
		System.out.println(bd.showVendedores());
	}
	public void showProductos() {
		System.out.println(bd.showProductos());
	}
	
}
