package com.siri.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageControlller {

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Home");
        mv.addObject("userClickedHome", true );
        return mv;
    }

    @RequestMapping(value = {"/about"})
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About Us");
        mv.addObject("userClickedAbout", true );
        return mv;
    }

    @RequestMapping(value = {"/contact"})
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact Us");
        mv.addObject("userClickedContact", true );
        return mv;
    }

    @RequestMapping(value = {"/listProducts"})
    public ModelAndView listProducts() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "List Products");
        mv.addObject("userClickedServices", true );
        return mv;
    }


}

