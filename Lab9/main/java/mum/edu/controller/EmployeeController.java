package mum.edu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.edu.domain.Employee;
import mum.edu.exception.EmployeeException;

@Controller
@RequestMapping({"/","/employee"})
public class EmployeeController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String display() {
		
		return "employee";
	}
		
	@RequestMapping(value = "/add", method = RequestMethod.POST)	
	public @ResponseBody Employee add(@Valid  @RequestBody  Employee employee)  throws EmployeeException{

		if (employee.getFirstName().equals("Ex")) {
			throw new EmployeeException(employee.getEmail(), "Unable to save employee with email: ");
		}
			
		return employee;
	}
	

	
	
}
