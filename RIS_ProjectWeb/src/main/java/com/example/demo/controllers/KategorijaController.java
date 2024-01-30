package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.KategorijaRepository;

import jakarta.servlet.http.HttpServletRequest;
import model.Kategorija;

@Controller
@RequestMapping("/kategorija/")
public class KategorijaController {

	
	@Autowired
	KategorijaRepository kar;
	
	@GetMapping("getDodajKategorijuPage")
	public String getDodajKategorijuPage() {
		return "dodajKategoriju";
	}
	
	@ModelAttribute("kategorija")
	public Kategorija getKategorije(){
		return new Kategorija();
	}
	
    @PostMapping("saveKategorija")
    public String saveProizvod(@ModelAttribute("kategorija") Kategorija kategorija, HttpServletRequest request) {
		String poruka = "";
		try {
			Kategorija k = kar.save(kategorija);
			poruka += "Uspesno je sacuvana kategorija proizvoda! Naziv kategorije je: "+k.getNaziv();
		} catch(Exception e) {
			poruka += "Greska prilikom cuvanja kategorije proizvoda!";
		}
		request.setAttribute("porukaKategorija", poruka);
        return "dodajKategoriju";
    }
	
    
	@GetMapping("getKategorijePage")
	public String getKategorijePage() {
		return "pregledKategorija";
	}
    
}