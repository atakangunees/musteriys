package com.course.musteriys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.course.musteriys.model.Musteri;
import com.course.musteriys.repository.MusteriRepository;
import com.course.musteriys.service.MusteriService;

@Controller
public class HomeController {

	@Autowired
	private MusteriRepository musRepo;
	
	@Autowired
	private MusteriService repoImp;
	
	@GetMapping(path = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(path="/create")
	public String showForm(ModelMap model) {
		Musteri m = new Musteri();
		model.addAttribute("musteri", m);
		return "form";
	}
	
	@PostMapping(path = "/create")
	public String addMusteri(@ModelAttribute("musteri") Musteri musteri, ModelMap model) {
		
		musRepo.save(musteri);
		model.addAttribute("mesaj", "Başarıyla kaydedildi");
		return "index";
	}
	
	@GetMapping(path="/list")
	public String showTable(ModelMap model) {
		Iterable<Musteri> musteriler = musRepo.findAll();
		model.addAttribute("musteriler", musteriler);
		return "list";
	}
	
	@GetMapping(path ="/list/paged/{no}/{size}")
	public String sortedList(@PathVariable(value = "no") int pageNo, 
							@PathVariable(value = "size") int pageSize,
							ModelMap model) {
		
		List<Musteri> pagedList = repoImp.sayfala(pageNo, pageSize);
		model.addAttribute("musteriler", pagedList);
		return "list";
	}
	
	@GetMapping(path="/delete/{id}")
	public String delete(@PathVariable(value="id") Long id, ModelMap model) {
		
		musRepo.deleteById(id);
		model.addAttribute("mesaj", "başarıyla silindi");
		return "index";
	}
	
	@GetMapping(path = "/edit/{id}")
	public String edit(@PathVariable(value="id") Long id, ModelMap model) {
		
		Musteri m = musRepo.findById(id).get();
		
		model.addAttribute("musteri", m);
		
		return "edit";
	}
	
	@PostMapping(path="/edit/{id}")
	public String update(@PathVariable(value="id") Long id, @ModelAttribute("musteri") Musteri musteri, ModelMap model) {
		
		musRepo.save(musteri);
		model.addAttribute("mesaj", "Güncellendi");
		return "index";
	}
}
