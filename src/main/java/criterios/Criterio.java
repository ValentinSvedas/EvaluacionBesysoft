package criterios;

import modelo.Producto;

import java.util.List;

public abstract class Criterio {
    public abstract List<Producto> cumple(List<Producto> p);
}
