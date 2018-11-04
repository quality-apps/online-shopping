package com.siri.shoppingbackend.daoimpl;

import com.siri.shoppingbackend.dao.ProductDAO;
import com.siri.shoppingbackend.dto.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class ProductDAOImplTest {

  private static AnnotationConfigApplicationContext context;
  private static ProductDAO productDAO;
  private Product product;

  @BeforeClass
  public static void setUp() throws Exception {

    context = new AnnotationConfigApplicationContext();
    context.scan("com.siri.shoppingbackend");
    context.refresh();

    productDAO = (ProductDAO) context.getBean("productDAO");
  }

  @Test
  public void litsProducts() {}

  @Test
  public void get() {
    assertEquals("Getting a product", "Oppo Selfie S53", productDAO.get(6).getName());
  }

  @Test
  public void add() {

    product = new Product();

    product.setName("Oppo Selfie S53");
    product.setBrand("Oppo");
    product.setDescription("This is some description for oppo mobile phones!");
    product.setUnitPrice(25000);
    product.setActive(true);
    product.setCategoryId(3);
    product.setSupplierId(3);

    assertEquals("inserting a new product!", true, productDAO.add(product));
  }

  @Test
  public void update() {
    Product product = productDAO.get(6);
    product.setName("Oppo S53");
    assertEquals("update", true, productDAO.update(product));
  }

  @Test
  public void delete() {
    Product product = productDAO.get(6);
    assertEquals("delete", true, productDAO.delete(product));
  }

  @Test
  public void listActiveProducts() {
    assertEquals("get active list", 5, productDAO.listActiveProducts().size());
  }

  @Test
  public void listActiveProductsByCategory() {
    assertEquals(
        "get active list by category", 3, productDAO.listActiveProductsByCategory(3).size());
  }

  @Test
  public void getLatestActiveProducts() {
    assertEquals("lastest active products", 3, productDAO.getLatestActiveProducts(3).size());
  }

  @Test
  public void CRUDoprerations() {
//    add();
    get();
    update();
    delete();

    listActiveProducts();
    listActiveProductsByCategory();
    getLatestActiveProducts();
  }
}
