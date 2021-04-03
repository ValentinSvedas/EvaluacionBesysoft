package filtros;

import tienda.Producto;

public class CriterioPrecioMenor extends Criterio{

		
	private int precio;
	
	public CriterioPrecioMenor(int precio) {
		this.precio=precio;
	}
	
	@Override
	public boolean cumple(Producto p) {
		// TODO Auto-generated method stub
		return precio > p.getPrecio();
	}
	
}
