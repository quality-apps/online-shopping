package com.siri.shoppingbackend.daoimpl;

import com.siri.shoppingbackend.dao.ProductDAO;
import com.siri.shoppingbackend.dto.Product;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

  @Autowired private SessionFactory sessionFactory;

  @Override
  public List litsProducts() {
    String listProducts = "FROM Products";
    Query query = sessionFactory.getCurrentSession().createQuery(listProducts);
    return query.getResultList();
  }

  @Override
  public Product get(int id) {
    return sessionFactory.getCurrentSession().get(Product.class, id);
  }

  @Override
  public boolean add(Product product) {

    try {
      sessionFactory.getCurrentSession().persist(product);
      return true;
    } catch (HibernateException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean update(Product product) {
    try {
      sessionFactory.getCurrentSession().update(product);
      return true;
    } catch (HibernateException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean delete(Product product) {
    product.setActive(false);
    try {
      sessionFactory.getCurrentSession().update(product);
      return true;
    } catch (HibernateException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public List<Product> listActiveProducts() {
    String listProducts = "FROM Product WHERE active = :active";
    Query query = sessionFactory.getCurrentSession().createQuery(listProducts);
    query.setParameter("active", true);
    return query.getResultList();
  }

  @Override
  public List<Product> listActiveProductsByCategory(int categoryId) {
    String listProducts = "FROM Product WHERE is_active = :active AND category_id = :categoryId";
    Query query = sessionFactory.getCurrentSession().createQuery(listProducts);
    query.setParameter("active", true);
    query.setParameter("categoryId", categoryId);
    return query.getResultList();
  }

  @Override
  public List<Product> getLatestActiveProducts(int count) {
    String listProducts = "FROM Product WHERE is_active = :active ORDER BY id";
    Query query = sessionFactory.getCurrentSession().createQuery(listProducts);
    query.setParameter("active", true);
    query.setFirstResult(0);
    query.setMaxResults(count);
    return query.getResultList();
  }
}
