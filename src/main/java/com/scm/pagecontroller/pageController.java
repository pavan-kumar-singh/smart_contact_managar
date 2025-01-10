package com.scm.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @RequestMapping ("/home")
    public String homePage(){
        System.out.println("this is home page");
        return "home";
    }

    @RequestMapping ("/contact")
    public String contactPage(){
        System.out.println("this is navbar page");
        return "contact";
    }

    @RequestMapping ("/about")
    public String aboutPage(){
        System.out.println("this is about page");
        return "about";
    }
    @RequestMapping ("/login")
    public String loginPage(){
        System.out.println("this is navbar page");
        return "login";
    }

    @RequestMapping ("/register")
    public String registerPage(){
        System.out.println("this is navbar page");
        return "register";
    }
    @RequestMapping ("/services")
    public String servicesPage(){
        System.out.println("this is navbar page");
        return "services";
    }


}
