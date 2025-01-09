package com.scm.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @RequestMapping ("/home")
    public String home(){
        System.out.println("this is home page");
        return "home";
    }

    @RequestMapping ("/navbar")
    public String nav(){
        System.out.println("this is navbar page");
        return "navbar";
    }

    @RequestMapping ("/about")
    public String aboutpage(){
        System.out.println("this is about page");
        return "about";
    }
}
