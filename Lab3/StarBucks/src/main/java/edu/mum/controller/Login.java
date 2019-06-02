package edu.mum.controller;

import edu.mum.domain.User;
import edu.mum.service.CoffeService;
import edu.mum.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Login {

    @Autowired
    LoginService loginService;

    @Autowired
    CoffeService coffeService;

    @RequestMapping("/")
    public String loginPage(){
        System.out.println("Login page GET.");
        return "Login";
    }

    @RequestMapping(value="/Login",method={RequestMethod.POST})
    public String login(User user, Model model, RedirectAttributes redirectAttributes){
        System.out.println("Login page POST.");
        if(user.toString()
                .equals(loginService.getUser(user.getUsername(),
                        user.getPassword()).toString())){

            model.addAttribute("userName", user.getUsername());
            model.addAttribute("roast", coffeService.findRoast());
            //redirectAttributes.addFlashAttribute("userName", user.getUsername());
            return "Coffee";
        }
        //model.addAttribute("loginError", "Wrong Username or Password used.");
        redirectAttributes.addFlashAttribute("loginError", "Wrong Username or Password used.");

        return "redirect:/";
    }
}
