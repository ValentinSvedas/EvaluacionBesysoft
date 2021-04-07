package criterios;

import java.util.List;
import lombok.AllArgsConstructor;
import modelo.Producto;

@AllArgsConstructor
public class CriterioNombre extends Criterio{
    private String nombre;

    @Override
    public List<Producto> cumple(List<Producto> p) {
        p.removeIf(producto -> !producto.getNombre().equals(nombre));
        return p;
    }

}