package com.scm.pagecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User1;
import com.scm.entities.User1.User1Builder;
import com.scm.form.UserForm;
import com.scm.services.UserServices;

@Controller
public class pageController {

    @Autowired
    private UserServices userService;

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
        User1 user = User1.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phone(userForm.getPhone())
        .profilePic(
        "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75").
        build();

        User1 savedUser = userService.saveUser(user);

        System.out.println("user saved :");
        userService.saveUser(user);

        return "redirect:/register";
    }


}
