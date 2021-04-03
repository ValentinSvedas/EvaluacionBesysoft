package filtros;

import tienda.Producto;

public class CriterioCategoria extends Criterio{
	
	private String categoria;
	
	public CriterioCategoria(String categoria) {
		this.categoria=categoria;
	}

	@Override
	public boolean cumple(Producto p) {
		return categoria.equals(p.getCategoria());
	}

}
