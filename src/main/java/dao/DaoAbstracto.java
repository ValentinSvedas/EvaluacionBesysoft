package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;

public class DaoAbstracto<T> {

  protected final Class<T> entityClass;
  protected EntityManager entityManager;

  public DaoAbstracto(Class<T> entityClass, EntityManager entityManager) {
    this.entityClass = entityClass;
    this.entityManager = entityManager;
  }

  protected EntityManager getEntityManager() {
    return entityManager;
  }

  public void guardar(T entity) {
    getEntityManager().getTransaction().begin();
    getEntityManager().persist(entity);
    getEntityManager().getTransaction().commit();
  }

  public T find(Object id) throws NoResultException {
    try {
      return getEntityManager().find(entityClass, id);
    } catch (NoResultException noResultException) {
      throw new NoResultException("No encontrado en la base de datos");
    }
  }

  public List<T> findAll() {
    CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
    cq.select(cq.from(entityClass));
    return getEntityManager().createQuery(cq).getResultList();
  }

  public void close() {
    entityManager.close();
  }
}
