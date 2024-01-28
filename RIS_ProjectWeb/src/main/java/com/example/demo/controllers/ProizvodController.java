package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repositories.KorisnikRepository;
import com.example.demo.repositories.OcenaRepository;
import com.example.demo.repositories.OmiljenoRepository;
import com.example.demo.repositories.ProizvodRepository;

import jakarta.servlet.http.HttpServletRequest;
import model.Korisnik;
import model.Ocena;
import model.OcenaPK;
import model.Omiljeno;
import model.OmiljenoPK;
import model.Proizvod;

@Controller
@RequestMapping(value="/proizvod/")
public class ProizvodController {
	
	@Autowired
	ProizvodRepository pr;
	
	@Autowired
	OcenaRepository or;
	
	@Autowired
	KorisnikRepository kr;
	
	@Autowired
	OmiljenoRepository omr;
	
	@GetMapping("getProizvodi")
	public String getKategorije(HttpServletRequest request) {
		List<Proizvod> proz = pr.findAll();
		request.getSession().setAttribute("proizvodi", proz);
		return "pregledProizvoda";
	}
	
	@GetMapping("getProizvodiKupac")
	public String getKategorijeKupac(HttpServletRequest request) {
		List<Proizvod> proz = pr.findAll();
		request.getSession().setAttribute("proizvodi", proz);
		return "pregledProzivodaKupac";
	}
	
	@GetMapping("getProizvod")
	public String getGlumci(@RequestParam("idP")Integer idProizvoda, HttpServletRequest request) {
		Proizvod p = pr.getReferenceById(idProizvoda);
		request.getSession().setAttribute("proizvod", p);
		return "proizvod";
	}
	
    @PostMapping("savePodaci")
    public String savePodaci(Integer ocena, String omlijen, HttpServletRequest request) {
	    Korisnik trenutniKorisnik = (Korisnik) request.getSession().getAttribute("trenutniKorisnik");
		Proizvod p = (Proizvod) request.getSession().getAttribute("proizvod");
    	if(ocena != null) {
    		OcenaPK opk = new OcenaPK();
    		opk.setKorisnik_username(trenutniKorisnik.getUsername());
    		opk.setProizvod_idProizvod(p.getIdProizvod());
        	Ocena o = new Ocena();
        	o.setId(opk);
        	o.setKorisnik(trenutniKorisnik);
        	o.setProizvod(p);
        	o.setOcena(ocena);
        	or.save(o);
        	trenutniKorisnik.addOcena(o);
        	kr.save(trenutniKorisnik);
        	p.addOcena(o);
        	pr.save(p);
    	}
    	else {
    		OcenaPK opk = new OcenaPK();
    		opk.setKorisnik_username(trenutniKorisnik.getUsername());
    		opk.setProizvod_idProizvod(p.getIdProizvod());
        	try {
        		or.delete(or.getReferenceById(opk));
        		trenutniKorisnik.removeOcena(or.getReferenceById(opk));
        		kr.save(trenutniKorisnik);
        		p.removeOcena(or.getReferenceById(opk));
        		pr.save(p);
        	} catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	if(omlijen != null && omlijen.equals("on")) {
        	OmiljenoPK ompk = new OmiljenoPK();
        	ompk.setKorisnik_username(trenutniKorisnik.getUsername());
        	ompk.setProizvod_idProizvod(p.getIdProizvod());
        	Omiljeno om = new Omiljeno();
        	om.setId(ompk);
        	om.setKorisnik(trenutniKorisnik);
        	om.setProizvod(p);
        	omr.save(om);
        	trenutniKorisnik.addOmiljeno(om);
        	p.addOmiljeno(om);
        	kr.save(trenutniKorisnik);
        	pr.save(p);
    	}
    	else {
        	OmiljenoPK ompk = new OmiljenoPK();
        	ompk.setKorisnik_username(trenutniKorisnik.getUsername());
        	ompk.setProizvod_idProizvod(p.getIdProizvod());
        	try {
        		omr.delete(omr.getReferenceById(ompk));
        		trenutniKorisnik.removeOmiljeno(omr.getReferenceById(ompk));
        		kr.save(trenutniKorisnik);
        		p.removeOmiljeno(omr.getReferenceById(ompk));
        		pr.save(p);
        	}catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	return "pregledProzivodaKupac";
    }
	
}