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
	public void addProducto(Producto p) {
		productos.add(p);
	}
	public int cantidadProductos() {
		return productos.size();
	}
	public List<Vendedor> showVendedores(){
		List<Vendedor> auxVendedores = new ArrayList<>(vendedores);
		return auxVendedores;
	}
	public List<Producto> showProductos(){
		List<Producto> auxProductos = new ArrayList<>(productos);
		return auxProductos;
	}
	public Vendedor vendedorN(int n) {
		if(vendedores.size()>n)
		return vendedores.get(n);
		else return null;
	}
	public Producto productoN(int n) {
		if(vendedores.size()>n)
		return productos.get(n);
		else return null;
	}
	public List<Producto> showProductosDelVendedor(Vendedor v){
		List<Producto> auxProductos = new ArrayList<>(productos);
		for(Producto paux: productos) {
			if(paux.getVendedor().equals(v))
				auxProductos.add(paux);
		}
		return auxProductos;
	}
}