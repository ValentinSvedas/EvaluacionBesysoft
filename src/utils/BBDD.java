package utils;

import java.util.ArrayList;
import java.util.List;

import tienda.Producto;
import tienda.Vendedor;

public class BBDD {

	List<Vendedor> vendedores;
	List<Producto> productos;

	public BBDD() {
		this.productos = new ArrayList<>();
		this.vendedores = new ArrayList<>();
	}
	
	public void addVendedor(String nombre, int sueldo) {
		Vendedor v = new Vendedor(vendedores.size()+1, nombre,sueldo);
		vendedores.add(v);
	}
	public void addProducto(String nombre, int precio, String categoria) {
		Producto p = new Producto(productos.size()+1, nombre,precio,categoria);
		productos.add(p);
	}
	
	public List<Vendedor> showVendedores(){
		List<Vendedor> auxVendedores = new ArrayList<>(vendedores);
		return auxVendedores;
	}
	public List<Producto> showProductos(){
		List<Producto> auxProductos = new ArrayList<>(productos);
		return auxProductos;
	}
}