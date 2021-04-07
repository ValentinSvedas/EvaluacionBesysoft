package dao;

import modelo.Vendedor;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class VendedorDaoAbstracto extends DaoAbstracto<Vendedor> {

  public VendedorDaoAbstracto(EntityManager entityManager) {
    super(Vendedor.class, entityManager);
  }

  public Vendedor encontrarPorCodigo(String codigo) {
    try {
      Query query = entityManager.createQuery("SELECT p from Vendedor p where codigo = :codigo");
      query.setParameter("codigo", codigo);
      return (Vendedor) query.getSingleResult();
    } catch (NoResultException noResultException) {
      throw new RuntimeException("Codigo no encontraddo");
    }
  }

  @Override
  public void guardar(Vendedor entity) {
    try {
      super.guardar(entity);

    } catch (PersistenceException e) {
      throw new RuntimeException("El codigo deberia ser unico.");
    }
  }
}
