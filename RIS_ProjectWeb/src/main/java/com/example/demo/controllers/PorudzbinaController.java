package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.PorudzbinaHasProizvodRepository;
import com.example.demo.repositories.PorudzbinaRepository;

import jakarta.servlet.http.HttpServletRequest;
import model.Korisnik;
import model.Porudzbina;
import model.PorudzbinaHasProizvod;
import model.Proizvod;



@Controller
@RequestMapping("/porudzbina/")
public class PorudzbinaController {
	
	@Autowired
	PorudzbinaRepository pr;
	
	@Autowired
	PorudzbinaHasProizvodRepository phpr;
	
    @GetMapping("getPorudzbina")
    public String getPorudzbina(HttpServletRequest request) {
	    Korisnik trenutniKorisnik = (Korisnik) request.getSession().getAttribute("trenutniKorisnik");
	    Porudzbina p = pr.getReferenceById(trenutniKorisnik.getUsername());
		List<PorudzbinaHasProizvod> porudzbina = phpr.getPorudzbinaZaKorisnika(trenutniKorisnik.getUsername());
		List<Proizvod> proizvodi = new ArrayList<>();
		List<Integer> kolicine = new ArrayList<>();
		for (PorudzbinaHasProizvod php : porudzbina) {
			proizvodi.add(php.getProizvod());
			kolicine.add(php.getKolicina());
		}
		request.setAttribute("porudzbine", proizvodi);
		request.setAttribute("kolicine", kolicine);
		request.setAttribute("porudzbina", p);
		return "porudzbina";
    }
	
    
    
}