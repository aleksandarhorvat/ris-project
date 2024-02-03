package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.example.demo.repositories.KarticaRepository;
import com.example.demo.repositories.KorisnikRepository;

import jakarta.servlet.http.HttpServletRequest;
import model.Kartica;
import model.KarticaPK;
import model.Korisnik;

@Controller
@RequestMapping("/kartica/")
public class KarticaController {

    @Autowired
    KorisnikRepository kr;
    
    @Autowired
    KarticaRepository kar;
    
	@GetMapping("getKartica")
	public String getKartica() {
		return "kupac/kartica";
	}
	
	@ModelAttribute("kartica")
	public KarticaPK newKartica() {
		return new KarticaPK();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true); 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true)); 
	}
	
	@PostMapping("saveKartica")
	public String savePredstava(@ModelAttribute("kartica") KarticaPK kartica, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) {
	    Korisnik trenutniKorisnik = kr.findByUsername(userDetails.getUsername());
	    
	    String poruka = "";
	    
	    try {
	        kartica.setKorisnik_username(trenutniKorisnik.getUsername());
	        
	        Kartica k = new Kartica();
	        k.setId(kartica);
	        k.setKorisnik(trenutniKorisnik);
	        
	        // Remove the extra korisnik_username value from the insert statement
	        kar.save(k);
	        
	        trenutniKorisnik.addKartica(k);
	        kr.save(trenutniKorisnik);
	        
	        poruka += "Uspesno je sacuvana kartica! Username korisnika cija je kartica: " + k.getKorisnik().getUsername();
	    } catch (Exception e) {
	        poruka += "Greska prilikom cuvanja kartice!";
	    }
	    
	    request.setAttribute("porukaKartica", poruka);
	    
	    return "kupac/kartica";
	}


}