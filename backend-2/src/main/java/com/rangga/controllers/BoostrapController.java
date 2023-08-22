package com.rangga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rangga.entity.EmployeeEntity;
import com.rangga.services.EmployeeService;

@Controller
@RequestMapping("/test")
public class BoostrapController {
	
	@Autowired
	private EmployeeService ks;
	
	@RequestMapping("/")
	public String dashboard(Model model) {
		model.addAttribute("listKaryawan",ks.FindAllQ());
		for(int i = 0 ;i < ks.FindAllQ().size();i++) {
			System.out.println(ks.FindAllQ().toString());
		}
		return "dashboard.html";
	}
	
	@GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        EmployeeEntity karyawan = new EmployeeEntity();
        model.addAttribute("karyawan", karyawan);

        return "tambahKaryawan";
    }
	
	 @PostMapping("/save")
	    public String saveEmployee(@ModelAttribute("karyawan") EmployeeEntity karyawan) {
		 karyawan.getName();
		 karyawan.getBirthDate();
		 karyawan.getPositionId();
		 karyawan.getIdNumber();
		 karyawan.getGender();
	     ks.saveEmployee(karyawan);
	     return "redirect:/test/";
	    }
	 
	 @PostMapping("/uptodate")
	    public String updateEmployee(@ModelAttribute("karyawan") EmployeeEntity model) {
		 model.getName();
		 model.getBirthDate();
		 model.getPositionId();
		 model.getIdNumber();
		 model.getGender();
	     ks.saveEmployee(model);
	        return "redirect:/test/";
	    }
	 
	 @GetMapping("showFormForUpdate/{id}")
	    public String updateForm(@PathVariable(value = "id") int id, Model model) {
	        EmployeeEntity karyawan = ks.getEmployeeById(id);
	        model.addAttribute("karyawan", karyawan);
	        return "update";
	    }
	  
	    @GetMapping("deleteKaryawan/{id}")
	    public String deleteThroughId(@PathVariable(value = "id") int id,EmployeeEntity employee) {
	       ks.deleteEmployee(id, employee);
	       return "redirect:/test/";
	  
	    }


}
