package com.siri.shoppingbackend.daoimpl;

import com.siri.shoppingbackend.dao.CategoryDAO;
import com.siri.shoppingbackend.dto.Category;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

  @Autowired private SessionFactory sessionFactory;

  @Override
  public List<Category> litsCategory() {

    String selectListofCategories = "FROM Category WHERE is_active = :active";
    Query query = sessionFactory.getCurrentSession().createQuery(selectListofCategories);
    query.setParameter("active", true);
    return query.getResultList();
  }

  /*
  getting a single category
   */
  @Override
  public Category get(final int id) {
    return sessionFactory.getCurrentSession().get(Category.class, id);
  }

  /*
  adding a single category
   */
  @Override
  @Transactional
  public boolean add(Category category) {
    try {
      sessionFactory.getCurrentSession().persist(category);
      return true;
    } catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
  }

  /*
  update a single category
   */
  @Override
  public boolean update(Category category) {
    try {
      sessionFactory.getCurrentSession().update(category);
      return true;
    } catch (HibernateException e) {
      e.printStackTrace();
      return false;
    }
  }

  /*
  Delete a single category
   */
  @Override
  public boolean delete(Category category) {

    category.setActive(false);
    try {
      sessionFactory.getCurrentSession().update(category);
      return true;
    } catch (HibernateException e) {
      e.printStackTrace();
      return false;
    }
  }
}
