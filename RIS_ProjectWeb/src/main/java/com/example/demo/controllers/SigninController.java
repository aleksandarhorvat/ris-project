package com.example.demo.controllers;

import model.Korisnik;
import model.Uloga;
import com.example.demo.repositories.KarticaRepository;
import com.example.demo.repositories.KorisnikRepository;
import com.example.demo.repositories.UlogaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/signin/")
public class SigninController {

    @Autowired
    KorisnikRepository kr;

    @Autowired
    UlogaRepository ur;

    @Autowired
    KarticaRepository kar;

	@GetMapping("getSigninPage")
	public String getSigninPage() {
		return "signIn";
	}
    
	@ModelAttribute("korisnik")
	public Korisnik newKorisnik() {
		return new Korisnik();
	}
	
	@ModelAttribute("uloge")
	public List<Uloga> getUloge(){
		return ur.findAll();
	}

    @PostMapping("saveKorisnik")
    public String saveKorisnik(@ModelAttribute("korisnik") Korisnik korisnik, Model m) {
		String poruka = "";
		try {
			Korisnik k = kr.save(korisnik);
			poruka += "Uspesno je sacuvan korisnik! Username korisnika je: "+k.getUsername();
		} catch(Exception e) {
			poruka += "Greska prilikom cuvanja korisnika!";
		}
		m.addAttribute("porukaKorisnik", poruka);
        return "signIn";
    }
}
