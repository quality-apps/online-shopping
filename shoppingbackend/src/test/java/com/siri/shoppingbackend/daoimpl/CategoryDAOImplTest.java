package com.siri.shoppingbackend.daoimpl;

import com.siri.shoppingbackend.dao.CategoryDAO;
import com.siri.shoppingbackend.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class CategoryDAOImplTest {

  private static AnnotationConfigApplicationContext context;
  private static CategoryDAO categoryDAO;
  private Category category;

  @BeforeClass
  public static void setUp() throws Exception {

    context = new AnnotationConfigApplicationContext();
    context.scan("com.siri.shoppingbackend");
    context.refresh();

    categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
  }

  /*
  get a single category
   */
  @Test
  public void get() {
    int id = 1;
    assertEquals("correct Category loaded", "Nokia 6.1 plus", categoryDAO.get(id).getName());
  }

  /*
  Test the update a single category
   */
  @Test
  public void update() {
    Category category = categoryDAO.get(3);
    if (category != null) {
      category.setImageUrl("CAT_10.png");
      assertEquals("Updated", true, categoryDAO.update(category));
    }
  }

  /*
  tests the delete a single category. actually active flag is set as false in here
   */
  @Test
  public void delete() {
    Category category = categoryDAO.get(3);
    if (category != null) {
      assertEquals("deleted", true, categoryDAO.delete(category));
    }
  }

  /*
  tests the list of categories
   */
  @Test
  public void litsCategory() {

    assertEquals("get the list", 1, categoryDAO.litsCategory().size());
  }

  /*
  add a single category
   */
  @Test
  public void add() {
    category = new Category();
    //        category.setName("Nokia 6.1 plus");
    //        category.setDescription("This is a description for a Nokia 6.1 plus");
    //        category.setImageUrl("CAT_2.png");
    //
    //        assertEquals("success", true, categoryDAO.add(category));

    category.setName("TV SONY");
    category.setDescription("This is a description for a SONY TV");
    category.setImageUrl("CAT_123.png");
    assertEquals("success", true, categoryDAO.add(category));
  }

  @Test
  public void CRUDoperation() {
      add();
      update();
      delete();
      litsCategory();

  }
}
