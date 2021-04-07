package utils;

import criterios.Criterio;
import criterios.CriterioCategoria;
import criterios.CriterioNombre;
import modelo.Producto;
import modelo.Vendedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private final AdministradorBBDD ABD = new AdministradorBBDD();

	public void menuVentas() {
		Scanner sc = new Scanner(System.in);
		String op = "";
		while(!op.equals("0")) {
			System.out.println("0  Salir");
			System.out.println("1  Agregar vendedor");
			System.out.println("2  Agregar producto");
			System.out.println("3  Buscar producto por criterio");
			System.out.println("4  Mostrar todos los producto");
			System.out.println("5  Mostrar todos los vendedores");
			System.out.println("6 Asociar producto al vendedor");
			System.out.println("7 Calcular comision");
			System.out.println("8 Vender producto");
			op = sc.nextLine();
			switch(op) {
				case "0": break;
				case "1": addVendedor(sc);
				break;
				case "2": addProducto(sc);
				break;
				case "3": buscarProducto(sc);
				break;
				case "4": mostrarProductos();
				break;
				case "5": mostrarVendedores();
				break;
				case "6": agregarProductoVendedor(sc);
				break;
				case "7": calcularComision(sc);
				break;
				case "8": venderProducto(sc);
			}
		}

	}

	private void venderProducto(Scanner sc) {
		System.out.print("Codigo vendedor: ");
		Vendedor v = ABD.findElementVendedor(sc.nextInt());
		System.out.println("Seleccionar producto: ");
		System.out.println(ABD.findAllProductos());
		int op = sc.nextInt();
		try{
			ABD.venderProducto(v,op);
		}catch (Exception e){
			System.out.println(e);
		}
	}

	private void calcularComision(Scanner sc) {
		System.out.println("Selecciona vendedor con su codigo para calcular su comision");
		System.out.println(ABD.findAllVendedores());
		int op = sc.nextInt();
		System.out.println(
				ABD.findElementVendedor(op).calcularComision()
		);
	}

	private void agregarProductoVendedor(Scanner sc) {
		try {
			System.out.print("Codigo del vendedor: ");
			Vendedor v = ABD.findElementVendedor(sc.nextInt());
			System.out.print("Codigo del producto: ");
			System.out.print(ABD.addProductoVendedor(v, sc.nextInt()));
		}catch (Exception e){
			System.out.print(e);
		}
	}

	private void buscarProducto(Scanner sc) {
		List<Criterio> criterios = new ArrayList<>();
		String op ="";
		while(!op.equals("0")){
			System.out.println("1 - para agregar filtro por categoria");
			System.out.println("2 - para agregar filtro por nombre");
			System.out.println("0 - para parar de agregar filtros");
			op = sc.nextLine();
			if(op.equals("1")){
				System.out.print("Ingresa la categoria ");
				criterios.add(new CriterioCategoria((sc.nextLine())));
			}else if(op.equals("2")){
				System.out.print("Nombre del producto ");
				criterios.add(new CriterioNombre(sc.nextLine()));
			}
		}
		System.out.print(ABD.findAllPorCriterios(criterios));
	}

	private void mostrarProductos() {
		System.out.print(ABD.findAllProductos());
	}
	private void mostrarVendedores() {
		System.out.print(ABD.findAllVendedores());
	}

	public void addVendedor(Scanner sc){
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Sueldo: ");
		double sueldo = sc.nextDouble();
		try{
			System.out.print(ABD.addVendedor(
					Vendedor.builder().nombre(nombre).sueldo(sueldo).build()));
		}catch (Exception e){
			System.out.print(e);
		}
	}

	public void addProducto(Scanner sc){
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Precio: ");
		double precio= sc.nextDouble();
		System.out.print("Categoria: ");
		String categoria= sc.next();
		try{
			System.out.println(
					ABD.addProducto(Producto.builder().nombre(nombre).precio(precio).categoria(categoria).build()));
		}catch (Exception e){
			System.out.print(e);
		}
	}
}
