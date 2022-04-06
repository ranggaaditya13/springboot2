package com.rangga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rangga.models.karyawanModel;
import com.rangga.services.karyawanService;

@Controller
public class BoostrapController {
	
	@Autowired
	private karyawanService ks;
	
	@RequestMapping("/")
	public String dashboard(Model model) {
		model.addAttribute("listKaryawan",ks.getAllData());
		return "dashboard.html";
	}
	
	@GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        karyawanModel karyawan = new karyawanModel();
        model.addAttribute("karyawan", karyawan);
        return "tambahKaryawan";
    }
	
	 @PostMapping("/save")
	    public String saveEmployee(@ModelAttribute("karyawan") karyawanModel karyawan) {
		 karyawan.getNama();
		 karyawan.getGender();
		 karyawan.getEmail();
		 karyawan.getAlamat();
		 karyawan.getNo_hp();
	     ks.insertData(karyawan);
	     return "redirect:/";
	    }
	
	 @PostMapping("/uptodate")
	    public String updateEmployee(@ModelAttribute("karyawan") karyawanModel model) {
		 	model.getId();
			model.getNama();
			model.getGender();
			model.getEmail();
			model.getAlamat();
			model.getNo_hp();
			ks.insertData(model);
	        return "redirect:/";
	    }
	 
	 @GetMapping("/showFormForUpdate/{id}")
	    public String updateForm(@PathVariable(value = "id") int id, Model model) {
	        karyawanModel karyawan = ks.getById(id);
	        model.addAttribute("karyawan", karyawan);
	        return "update";
	    }
	  
	    @GetMapping("/deleteKaryawan/{id}")
	    public String deleteThroughId(@PathVariable(value = "id") int id) {
	       ks.deleteViaId(id);
	       return "redirect:/";
	  
	    }


}
