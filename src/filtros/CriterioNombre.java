package filtros;

import tienda.Producto;

public class CriterioNombre extends Criterio{

	private String nombre;
	
	public CriterioNombre(String nombre) {
		this.nombre=nombre;
	}
	
	@Override
	public boolean cumple(Producto p) {
		return nombre.equals(p.getNombre());
	}

}
