package com.siri.onlineshopping.controller;

import com.siri.shoppingbackend.dao.CategoryDAO;
import com.siri.shoppingbackend.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageControlller {

    @Autowired
    private CategoryDAO categoryDAO;

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Home");

        mv.addObject("categories", categoryDAO.litsCategory());
        mv.addObject("userClickedHome", true);
        return mv;
    }

    @RequestMapping(value = {"/about"})
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About Us");
        mv.addObject("userClickedAbout", true);
        return mv;
    }

    @RequestMapping(value = {"/contact"})
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact Us");
        mv.addObject("userClickedContact", true);
        return mv;
    }

    @RequestMapping(value = {"/show/all/products"})
    public ModelAndView listProducts() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "All Products");
        mv.addObject("categories", categoryDAO.litsCategory());
        mv.addObject("userClickedAllProducts", true);
        return mv;
    }

    @RequestMapping(value = {"/show/category/{id}/products"})
    public ModelAndView listOneProduct(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("page");
        Category category = categoryDAO.get(id);
        mv.addObject("title", category.getId());
        mv.addObject("categories", categoryDAO.litsCategory());
        mv.addObject("category", category);
        mv.addObject("userClickedCategoryProduct", true);
        return mv;
    }

}

