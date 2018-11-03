package com.siri.shoppingbackend.daoimpl;

import com.siri.shoppingbackend.dao.CategoryDAO;
import com.siri.shoppingbackend.dto.Category;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

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

}
