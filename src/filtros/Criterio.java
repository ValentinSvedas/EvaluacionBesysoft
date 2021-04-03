package filtros;

import tienda.Producto;

public abstract class Criterio {
	public abstract boolean cumple(Producto p);

}
