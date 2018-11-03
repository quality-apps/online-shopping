package com.siri.shoppingbackend.daoimpl;

import com.siri.shoppingbackend.dao.CategoryDAO;
import com.siri.shoppingbackend.dto.Category;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class CategoryTestCase {

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

    @Test
    public void add() {

        category = new Category();
        category.setName("Nokia 6.1 plus");
        category.setDescription("This is a description for a Nokia 6.1 plus");
        category.setImageUrl("CAT_2.png");

        assertEquals("success", true, categoryDAO.add(category));
    }
}