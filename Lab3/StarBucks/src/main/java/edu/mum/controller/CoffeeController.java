package edu.mum.controller;

import edu.mum.domain.Coffee;
import edu.mum.service.CoffeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CoffeeController {

    @Autowired
    CoffeService coffeService;

    @PostMapping("/Coffee")
    public String coffeChoice(Coffee coffee, Model model,
                              RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("breeds", coffeService.findBreed(coffee.getRoast()));
        return "redirect:/Coffee";
    }
}
