package com.example.demo.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repositories.KategorijekorisnikaRepository;
import com.example.demo.repositories.OmiljenoRepository;
import com.example.demo.repositories.ProizvodRepository;

import jakarta.servlet.http.HttpServletRequest;
import model.Kategorijekorisnika;
import model.Korisnik;
import model.Omiljeno;
import model.OmiljenoPK;
import model.Proizvod;

@Controller
@RequestMapping("/kategorija/")
public class KategorijaController {
	
	@Autowired
	KategorijekorisnikaRepository kr;
	
	@Autowired
	OmiljenoRepository om;
	
	@Autowired
	ProizvodRepository pr;
    
	@GetMapping("getKategorijaPage")
	public String getKategorijaPage() {
		return "kategorija";
	}
    
	@GetMapping("getDodajProizvodePage")
	public String getDodajProizvodePage() {
	    return "dodajProzivode";
	}
	
	@ModelAttribute("kategorija")
	public Kategorijekorisnika newKategorija() {
		return new Kategorijekorisnika();
	}
	
	@ModelAttribute("kategorije")
	public List<Kategorijekorisnika> getKategorije(){
		return kr.findAll();
	}
	
	@ModelAttribute("omiljeni")
	public List<Proizvod> getOmiljeni(HttpServletRequest request){
	    Korisnik trenutniKorisnik = (Korisnik) request.getSession().getAttribute("trenutniKorisnik");
		List<Omiljeno> omiljeniList = om.getOmiljeniZaKorisnika(trenutniKorisnik.getUsername());
	    List<Proizvod> proizvodi = new ArrayList<>();

	    for(Omiljeno o : omiljeniList) {
	        Proizvod proizvod = pr.getReferenceById(o.getId().getProizvod_idProizvod());
	        proizvodi.add(proizvod);
	    }

	    return proizvodi;
	}
	
    @PostMapping("saveKategorija")
    public String saveKategorija(@ModelAttribute("kategorija") Kategorijekorisnika kategorija, Model m) {
		String poruka = "";
		try {
			List<Kategorijekorisnika> sve = kr.findAll();
			for (Kategorijekorisnika k : sve) {
				if(kategorija.getNaziv().equals(k.getNaziv())) {
					poruka += "Vec ima ta kategorija. ";
					throw new Exception();
				}
			}
			if(!kategorija.getNaziv().equals("")) {
				Kategorijekorisnika k = kr.save(kategorija);
				poruka += "Uspesno je sacuvana kategorija sa nazivom: "+k.getNaziv();
			}
		} catch(Exception e) {
			poruka += "Greska prilikom cuvanja kategorija!";
		}
		m.addAttribute("porukaKategorija", poruka);
        return "kategorija";
    }
    
    @PostMapping("saveProizvode")
    public String saveProizvode(int[] idOmiljeni, Integer idKategorija, HttpServletRequest request) {
	    Korisnik trenutniKorisnik = (Korisnik) request.getSession().getAttribute("trenutniKorisnik");
    	for (Integer id : idOmiljeni) {
    		OmiljenoPK ompk = new OmiljenoPK();
    		ompk.setKorisnik_username(trenutniKorisnik.getUsername());
    		ompk.setProizvod_idProizvod(id);
    		Omiljeno o = om.getReferenceById(ompk);
    		o.setKategorijekorisnika(kr.getReferenceById(idKategorija));
    		om.save(o);
		}
    	return "dodajProzivode";
    }
    
}