package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repositories.KorisnikRepository;
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
	KorisnikRepository kr;
	
	@Autowired
	PorudzbinaRepository pr;
	
	@Autowired
	PorudzbinaHasProizvodRepository phpr;
	
	@ModelAttribute("korisnici")
	public List<Korisnik> getKorisnici(){
		List<Korisnik> korisnici =  kr.findAll();
		List<Korisnik> returnK = new ArrayList<>();
		for (Korisnik k : korisnici) {
			if(k.getUloga().getIdUloga() == 2 && k.getPorudzbina() != null)
				returnK.add(k);
		}
		return returnK;
	}
	
	@ModelAttribute("porudzbine")
	public List<Porudzbina> getPorudzbine(){
		return pr.findAll();
	}
	
	@ModelAttribute("porudzbina")
	public Porudzbina getPorudzbina(){
		return new Porudzbina();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true); 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true)); 
	}
	
    @GetMapping("getPorudzbina")
    public String getPorudzbina(HttpServletRequest request, @AuthenticationPrincipal UserDetails userDetails) {
	    Korisnik trenutniKorisnik = kr.findByUsername(userDetails.getUsername());
	    if(trenutniKorisnik.getPorudzbina() == null)
	    	return "kupac/kupacPage";
	    Porudzbina p = pr.getReferenceById(trenutniKorisnik.getUsername());
		List<PorudzbinaHasProizvod> porudzbina = phpr.getPorudzbinaZaKorisnika(trenutniKorisnik.getUsername());
		List<Proizvod> proizvodi = new ArrayList<>();
		List<Integer> kolicine = new ArrayList<>();
		for (PorudzbinaHasProizvod php : porudzbina) {
			proizvodi.add(php.getProizvod());
			kolicine.add(php.getKolicina());
		}
		request.setAttribute("proizvodi", proizvodi);
		request.setAttribute("kolicine", kolicine);
		request.setAttribute("porudzbinaPrikaz", p);
		return "kupac/porudzbina";
    }
	
    @GetMapping("getPorudzbinePoDanimaPage")
    public String getPorudzbinePoDanimaPage() {
		return "admin/statistika/porudzbinePoDanima";
    }
    
	@GetMapping("getPorudzbine")
	public String getPorudzbine(Date datumNarucivanja, HttpServletRequest request) {
		List<Porudzbina> porudzbine = pr.getPorudzbineDatumNarucivanja(datumNarucivanja);
		request.setAttribute("brojPorudzbina", porudzbine.size());
		return "admin/statistika/porudzbinePoDanima";
	}
    
    @GetMapping("getPromenaStatusPorudzbinePage")
    public String getPromenaStatusaPorudzbinePage() {
		return "admin/promenaStatusPorudzbine";
    }
	
	@GetMapping("getPorudzbinu")
	public String getPorudzbinu(@RequestParam("idK")String username, HttpServletRequest request) {
		Porudzbina p = pr.getPorudzbinaKorisnika(username);
		request.setAttribute("proudzbinaIzmena", p);
		return "admin/promenaStatusPorudzbine";
	}
    
    @PostMapping("changeStatus")
    public String changeStatus(@ModelAttribute("porudzbina") Porudzbina porudzbina, HttpServletRequest request) {
		String poruka = "";
		Porudzbina p = pr.getReferenceById(porudzbina.getKorisnik().getUsername());
		try {
			if(!porudzbina.getStatus().equals("") && !p.getStatus().equals(porudzbina.getStatus())) {
				p.setStatus(porudzbina.getStatus());
			}
			pr.save(p);
			poruka += "Uspesno je promenjen status porudzbine! Status pordzbine je: " + p.getStatus();
		} catch(Exception e) {
			poruka += "Greska prilikom menjanja statusa porudzbine!";
		}
		request.setAttribute("porukaPorudzbina", poruka);
        return "admin/promenaStatusPorudzbine";
    }
	
}