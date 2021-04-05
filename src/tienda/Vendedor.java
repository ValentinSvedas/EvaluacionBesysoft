package tienda;

import java.util.HashSet;
import java.util.Set;

import filtros.Criterio;

public class Vendedor {

	private int codigo;
	private String nombre;
	private int sueldo;
	private Set<Producto> productos;
	private Set<Producto> productosVendidos;
	
	public Vendedor(int codigo, String nombre, int sueldo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.productos = new HashSet<Producto>();
		this.productosVendidos = new HashSet<Producto>();
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getSueldo() {
		return sueldo;
	}
	
	public void agregarProducto(Producto p) { //Añade producto a la lista del vendedor
		if(!this.productos.contains(p)) {
			p.setVendedor(this);
			productos.add(p);
		}
	}
	
	public void venderProducto(Producto p) { 
		if(productos.contains(p)) {
			productosVendidos.add(p);
			productos.remove(p);
		}
	}
	
	public double calcularComision() { //Calcula la comision por ventas
		int ventasTotales=productosVendidos.size();
		int ganancias = 0;
		for(Producto p: productosVendidos) {
			ganancias+=p.getPrecio();
		}
		if(ventasTotales>2) {
			return ganancias*0.10;
		}else {
			return ganancias*0.05;
		}
	}

	public Set<Producto> buscarProductos(Criterio c){//Busca el producto segun el critero
		Set<Producto> pEncontrados= new HashSet<Producto>();
		for(Producto p : productos) {
			if(c.cumple(p)) {
				pEncontrados.add(p);
			}
		}
		return pEncontrados;
	}
	
	@Override
	public String toString() {
		return this.getCodigo() +" - " +this.getNombre();
	}
	
}
