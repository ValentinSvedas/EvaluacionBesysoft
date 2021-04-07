package utils;

import criterios.Criterio;
import modelo.Producto;
import modelo.Vendedor;
import dao.ProductoDaoAbstracto;
import dao.VendedorDaoAbstracto;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class AdministradorBBDD {

    private final ApplicationContext context = ApplicationContext.getInstance();
    private final EntityManager entityManager = context.getEntityManager();
    private final VendedorDaoAbstracto vendedorDao = new VendedorDaoAbstracto(entityManager);
    private final ProductoDaoAbstracto productoDao = new ProductoDaoAbstracto(entityManager);

    public Producto addProducto(Producto p){
        productoDao.guardar(p);
        return p;
    }

    public Vendedor addVendedor(Vendedor vendedor){
        vendedorDao.guardar(vendedor);
        return vendedor;
    }

    public List<Producto> findAllProductos(){
        return productoDao.findAll();
    }

    public Producto findElementProducto(int id){
        return productoDao.find(id);
    }

    public List<Producto> findAllPorCriterios(List<Criterio> c){
        List<Producto> productos= productoDao.findAll();
        c.forEach(criterio-> criterio.cumple(productos));
        return productos;
    }

    public List<Vendedor> findAllVendedores(){
        return vendedorDao.findAll();
    }

    public Vendedor findElementVendedor(int id){
        return vendedorDao.find(id);
    }

    public List<Producto> venderProducto(Vendedor vendedor, int p){
        Producto producto = findElementProducto(p);
        return vendedor.venderProducto(producto);
    }

    public Vendedor addProductoVendedor(Vendedor vendedor, int codigo) throws NoResultException{
        Producto p = findElementProducto(codigo);
        if (!p.equals(null))
        vendedor.addProducto(p);
        return vendedor;
    }
}
