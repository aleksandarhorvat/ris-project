package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repositories.ProizvodRepository;
import com.example.demo.repositories.ProizvodjacRepository;

import jakarta.servlet.http.HttpServletRequest;
import model.Proizvod;
import model.Proizvodjac;

@Controller
@RequestMapping("/proizvodjac/")
public class ProizvodjacController {

	@Autowired
	ProizvodjacRepository pr;
	
	@Autowired
	ProizvodRepository pror;
	
	@GetMapping("getDodajProizvodjacaPage")
	public String getDodajProizvodjacaPage() {
		return "dodajProizvodjaca";
	}
	
	@ModelAttribute("proizvodjac")
	public Proizvodjac getProizvodjac(){
		return new Proizvodjac();
	}
	
	@ModelAttribute("proizvodjaci")
	public List<Proizvodjac> getProizvodjaci(){
		return pr.findAll();
	}
	
    @PostMapping("saveProizvodjac")
    public String saveProizvod(@ModelAttribute("proizvodjac") Proizvodjac proizvodjac, HttpServletRequest request) {
		String poruka = "";
		try {
			Proizvodjac p = pr.save(proizvodjac);
			poruka += "Uspesno je sacuvan proizvodjac! Naziv proizvodjaca je: " + p.getNaziv();
		} catch(Exception e) {
			poruka += "Greska prilikom cuvanja proizvodjaca!";
		}
		request.setAttribute("porukaProizvodjac", poruka);
        return "dodajProizvodjaca";
    }
	
	@GetMapping("getProizvodjaciPage")
	public String getKategorijePage() {
		return "pregledProizvodjaca";
	}
    
	@GetMapping("getProizvodjaci")
	public String getKategorije(@RequestParam("idP")Integer idProizvodjac, HttpServletRequest request) {
		Proizvodjac p = pr.getReferenceById(idProizvodjac);
		request.setAttribute("proizvodjacIzmena", p);
		return "pregledProizvodjaca";
	}
	
	@GetMapping("deleteProizvodjac")
	public String deleteproizvodjac(@RequestParam("idP")Integer idProizvodjac, HttpServletRequest request) {
		Proizvodjac p = pr.getReferenceById(idProizvodjac);
		try {
			pr.delete(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "adminPage";
	}
	
    @PostMapping("changeProizvodjac")
    public String changeproizvodjac(@ModelAttribute("proizvodjac") Proizvodjac proizvodjac, HttpServletRequest request) {
		String poruka = "";
		Proizvodjac p = pr.getReferenceById(proizvodjac.getIdProizvodjac());
		try {
			if(!proizvodjac.getNaziv().equals("") && !p.getNaziv().equals(proizvodjac.getNaziv())) {
				p.setNaziv(proizvodjac.getNaziv());
			}
			pr.save(p);
			poruka += "Uspesno je promenjen proizvodjac! Naziv proizvodjaca je: " + p.getNaziv();
		} catch(Exception e) {
			poruka += "Greska prilikom menjanja proizvodjaca!";
		}
		request.setAttribute("porukaProizvodjac", poruka);
        return "pregledProizvodjaca";
    }
	
	@GetMapping("getProizvodiPoProzivodjacuPage")
	public String getProizvodiPoProzivodjacuPage() {
		return "proizvodiPoProizvodjacima";
	}
    
	@GetMapping("getProizvodi")
	public String getProizvodi(@RequestParam("idP")Integer idProzivodjac, HttpServletRequest request) {
		Proizvodjac p = pr.getReferenceById(idProzivodjac);
		List<Proizvod> proizvodi = pror.getProizvodiProzivodjaci(p.getIdProizvodjac());
		request.setAttribute("brojProizvoda", proizvodi.size());
		return "proizvodiPoProizvodjacima";
	}
    
}