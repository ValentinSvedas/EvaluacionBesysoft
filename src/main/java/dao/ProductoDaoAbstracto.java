package dao;

import modelo.Producto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class ProductoDaoAbstracto extends DaoAbstracto<Producto> {

  public ProductoDaoAbstracto(EntityManager entityManager) {
    super(Producto.class, entityManager);
  }

  public List<Producto> encontrarPorCategoria(String categoria) {
    try {
      Query query = entityManager.createQuery("SELECT c from Producto c where categoria like :categoria");
      query.setParameter("categoria", categoria);
      return (List<Producto>) query.getResultList();
    } catch (NoResultException noResultException) {
      throw new RuntimeException("No se encontraron con ese codigo");
    }
  }

  @Override
  public void guardar(Producto entity) {
    try {
      super.guardar(entity);
    } catch (PersistenceException e) {
      throw new RuntimeException("El codigo deberia ser unico");
    }
  }
}
