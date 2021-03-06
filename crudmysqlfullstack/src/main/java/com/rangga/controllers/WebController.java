package com.rangga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rangga.models.EmployeeModel;
import com.rangga.services.EmployeeService;

@Controller
public class WebController {
	
	@Autowired
	private EmployeeService es;
	
	@GetMapping("/")
	public String mainMenu(Model model) {
		model.addAttribute("listEmployee",es.listEmployee());
		return "mainmenu";
	}
	
	@GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        EmployeeModel employee = new EmployeeModel();
        model.addAttribute("employee", employee);
        return "newemployee";
    }
	
	 @PostMapping("/save")
	    public String saveEmployee(@ModelAttribute("employee") EmployeeModel employee) {
	        es.insertData(employee.getNama(),employee.getJenis_kelamin(),employee.getTelephone());
	        return "redirect:/";
	    }
	 
	 @PostMapping("/uptodate")
	    public String updateEmployee(@ModelAttribute("employee") EmployeeModel employee) {
	        es.UpdateData(employee.getNama(),employee.getJenis_kelamin(),employee.getTelephone(),employee.getId());
	        return "redirect:/";
	    }
	 
	 @GetMapping("/showFormForUpdate/{id}")
	    public String updateForm(@PathVariable(value = "id") int id, Model model) {
	        EmployeeModel employee = es.getById(id);
	        model.addAttribute("employee", employee);
	        return "update";
	    }
	  
	    @GetMapping("/deleteEmployee/{id}")
	    public String deleteThroughId(@PathVariable(value = "id") int id) {
	        es.deleteViaId(id);
	        return "redirect:/";
	  
	    }

}
