package edu.mum.controller;

import edu.mum.domain.Calculator;
import edu.mum.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@RequestMapping("/calculator")
@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @RequestMapping()
    public String welcome() {
        //System.out.println("inside welcome method");
        return "calculatorForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String calculate(Calculator calc, Model model){
        //System.out.println("inside calculate post");
        model.addAttribute("numOne", calc.getNumOne());
        model.addAttribute("numTwo", calc.getNumTwo());
        model.addAttribute("numThree", calc.getNumThree());
        model.addAttribute("numFour", calc.getNumFour());
        model.addAttribute("sum", calculatorService.getSum(calc));
        model.addAttribute("mul", calculatorService.getMul(calc));

        return "resultForm";
    }
}
