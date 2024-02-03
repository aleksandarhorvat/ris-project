package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repositories.KategorijaRepository;
import com.example.demo.repositories.ProizvodRepository;

import jakarta.servlet.http.HttpServletRequest;
import model.Kategorija;
import model.Proizvod;

@Controller
@RequestMapping("/kategorija/")
public class KategorijaController {

	
	@Autowired
	KategorijaRepository kar;
	
	@Autowired
	ProizvodRepository pr;
	
	@GetMapping("getDodajKategorijuPage")
	public String getDodajKategorijuPage() {
		return "admin/dodajKategoriju";
	}
	
	@ModelAttribute("kategorija")
	public Kategorija getKategorija(){
		return new Kategorija();
	}
	
	@ModelAttribute("kategorije")
	public List<Kategorija> getKategorije(){
		return kar.findAll();
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
        return "admin/dodajKategoriju";
    }
	
	@GetMapping("getKategorijePage")
	public String getKategorijePage() {
		return "admin/pregledKategorija";
	}
    
	@GetMapping("getKategorije")
	public String getKategorije(@RequestParam("idK")Integer idKategorija, HttpServletRequest request) {
		Kategorija k = kar.getReferenceById(idKategorija);
		request.setAttribute("kategorijaIzmena", k);
		return "admin.pregledKategorija";
	}
	
	@GetMapping("deleteKategorija")
	public String deleteKategorija(@RequestParam("idK")Integer idKategorija) {
		Kategorija k = kar.getReferenceById(idKategorija);
		try {
			kar.delete(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/adminPage";
	}
	
    @PostMapping("changeKategorija")
    public String changeKategorija(@ModelAttribute("kategorija") Kategorija kategorija, HttpServletRequest request) {
		String poruka = "";
		Kategorija k = kar.getReferenceById(kategorija.getIdKategorija());
		try {
			if(!kategorija.getNaziv().equals("") && !k.getNaziv().equals(kategorija.getNaziv())) {
				k.setNaziv(kategorija.getNaziv());
			}
			kar.save(k);
			poruka += "Uspesno je promenjena kategorija proizvoda! Naziv kategorije je: " + k.getNaziv();
		} catch(Exception e) {
			poruka += "Greska prilikom menjanja kategorije proizvoda!";
		}
		request.setAttribute("porukaKategorija", poruka);
        return "admin/pregledKategorija";
    }
	
	@GetMapping("getProizvodiPoKategorijiPage")
	public String getProizvodiPoKategorijiPage() {
		return "admin/statistika/proizvodiPoKategorijama";
	}
    
	@GetMapping("getProizvodi")
	public String getProizvodi(@RequestParam("idK")Integer idKategorija, HttpServletRequest request) {
		Kategorija k = kar.getReferenceById(idKategorija);
		List<Proizvod> proizvodi = pr.getProizvodiKategorije(k.getIdKategorija());
		request.setAttribute("brojProizvoda", proizvodi.size());
		return "admin/statistika/proizvodiPoKategorijama";
	}
}