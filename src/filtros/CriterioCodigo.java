package filtros;

import tienda.Producto;

public class CriterioCodigo extends Criterio{
	
	private int codigo;
	
	public CriterioCodigo(int codigo) {
		this.codigo=codigo;
	}
	
	@Override
	public boolean cumple(Producto p) {
		// TODO Auto-generated method stub
		return this.codigo == p.getCodigo();
	}

}