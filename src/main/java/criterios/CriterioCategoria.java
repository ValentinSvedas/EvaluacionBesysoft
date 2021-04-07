package criterios;

import java.util.List;
import lombok.AllArgsConstructor;
import modelo.Producto;

@AllArgsConstructor
public class CriterioCategoria extends Criterio{
    private String categoria;

    @Override
    public List<Producto> cumple(List<Producto> p) {
        p.removeIf(producto -> !producto.getCategoria().equals(categoria));
        return p;
    }

}
