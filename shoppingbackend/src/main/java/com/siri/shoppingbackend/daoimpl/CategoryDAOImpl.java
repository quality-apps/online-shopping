package com.siri.shoppingbackend.daoimpl;

import com.siri.shoppingbackend.dao.CategoryDAO;
import com.siri.shoppingbackend.dto.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {


    @Autowired
    private SessionFactory sessionFactory;
    /*
    Testing purpose code
     */
    private static List<Category> categoryList = new ArrayList<>();

    static {

        Category category1 = new Category();
        category1.setId(1);
        category1.setName("Television");
        category1.setDescription("This is a description for a Television");
        category1.setImageUrl("CAT_1.png");
        categoryList.add(category1);

        Category category2 = new Category();
        category2.setId(2);
        category2.setName("Nokia 6.1 plus");
        category2.setDescription("This is a description for a Nokia 6.1 plus");
        category2.setImageUrl("CAT_2.png");
        categoryList.add(category2);

    }

    @Override
    public List<Category> litsCategory() {
        return categoryList;
    }

    @Override
    public Category get(final int id) {
        Optional<Category> optional = categoryList.stream().filter(c -> c.getId() == id).findFirst();
        return optional.orElse(null);
    }



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
}
