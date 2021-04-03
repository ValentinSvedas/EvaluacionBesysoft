package filtros;

import tienda.Producto;

public class CriterioPrecioMayor extends Criterio{
	
private int precio;
	
	public CriterioPrecioMayor(int precio) {
		this.precio=precio;
	}
	
	@Override
	public boolean cumple(Producto p) {
		// TODO Auto-generated method stub
		return precio < p.getPrecio();
	}

}