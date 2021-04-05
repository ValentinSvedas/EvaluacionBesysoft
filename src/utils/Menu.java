package utils;

import java.util.Scanner;

public class Menu {	
	
	BBDD bd= new BBDD();
	
	public void menuVentas() {
		Scanner sc = new Scanner(System.in);
		String op = "";
		while(op!="0") {
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
				case "4": buscarProducto(sc);
				break;
				case "5": showVendedores();
				break;
				default: System.out.println("Opcion no encontradas");
			}
		}
	}
	
	public void addVendedor(Scanner sc) {
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Sueldo: ");
		try {
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
			
		}else {
			System.out.println("No existen vendedores");
		}
		
	}
	
	
	public void buscarProducto(Scanner sc) {
		
	}
	
	public void showVendedores() {
		System.out.println(bd.showVendedores());
	}
	public void showProductos() {
		System.out.println(bd.showProductos());
	}
	
}
