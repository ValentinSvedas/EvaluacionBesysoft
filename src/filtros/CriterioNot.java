package filtros;

import tienda.Producto;

public class CriterioNot extends Criterio{
	
	private Criterio c;
	
	public CriterioNot(Criterio c) {
		this.c=c;
	}

	@Override
	public boolean cumple(Producto p) {
		// TODO Auto-generated method stub
		return !c.cumple(p);
	}
	
	
	
	
}
