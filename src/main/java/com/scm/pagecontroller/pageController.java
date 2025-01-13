package com.scm.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.form.UserForm;

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

     @GetMapping("/register")
    public String register(Model model) {

        UserForm userForm = new UserForm();
        // default data bhi daal sakte hai
        // userForm.setName("Durgesh");
        // userForm.setAbout("This is about : Write something about yourself");
        model.addAttribute("userForm", userForm);
        return "register";
    }


    @RequestMapping ("/services")
    public String servicesPage(){
        System.out.println("this is navbar page");
        return "services";
    }

    @PostMapping ("/do-register")
    public String ProcessingRgister( @ModelAttribute UserForm userForm){
        System.out.println(userForm);
        return "redirect:/register";
    }


}
