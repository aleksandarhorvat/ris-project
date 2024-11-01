package com.example.demo.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.example.demo.repositories.KategorijaRepository;
import com.example.demo.repositories.KorisnikRepository;
import com.example.demo.repositories.OcenaRepository;
import com.example.demo.repositories.OmiljenoRepository;
import com.example.demo.repositories.PopustRepository;
import com.example.demo.repositories.PorudzbinaHasProizvodRepository;
import com.example.demo.repositories.PorudzbinaRepository;
import com.example.demo.repositories.ProizvodRepository;
import com.example.demo.repositories.ProizvodjacRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import model.Kategorija;
import model.Korisnik;
import model.Ocena;
import model.OcenaPK;
import model.Omiljeno;
import model.OmiljenoPK;
import model.Popust;
import model.Porudzbina;
import model.PorudzbinaHasProizvod;
import model.PorudzbinaHasProizvodPK;
import model.Proizvod;
import model.Proizvodjac;

@Controller
@RequestMapping(value="/proizvod/")
public class ProizvodController {
	
	@Autowired
	PopustRepository popr;
	
	@Autowired
	ProizvodjacRepository pror;
	
	@Autowired
	KategorijaRepository kar;
	
	@Autowired
	ProizvodRepository pr;
	
	@Autowired
	OcenaRepository or;
	
	@Autowired
	KorisnikRepository kr;
	
	@Autowired
	OmiljenoRepository omr;
	
	@Autowired
	PorudzbinaRepository por;
	
	@Autowired
	PorudzbinaHasProizvodRepository phpr;
	
	@GetMapping("getDodajProizvodPage")
	public String getProizvod(HttpServletRequest request) {
		return "admin/dodajProizvod";
	}
	
	@ModelAttribute("kategorije")
	public List<Kategorija> getKategorije(){
		return kar.findAll();
	}
	
	@ModelAttribute("proizvodjaci")
	public List<Proizvodjac> getProizvodjaci(){
		return pror.findAll();
	}
	
	@ModelAttribute("popusti")
	public List<Popust> getPopusti(){
	    List<Popust> popusti = popr.findAll();
	    Popust nullPopust = new Popust();
	    nullPopust.setIdPopust(0);
	    nullPopust.setProcenat(null);
	    popusti.add(nullPopust);
		return popusti;
	}
	
	@ModelAttribute("proizvodDodat")
	public Proizvod getProizvodDodat(){
		return new Proizvod();
	}
	
	@GetMapping("getProizvodi")
	public String getKategorije(HttpServletRequest request) {
		List<Proizvod> proz = pr.findAll();
		request.setAttribute("proizvodi", proz);
		return "pregledProizvoda";
	}
	
	@GetMapping("getProizvodiKupac")
	public String getKategorijeKupac(HttpServletRequest request) {
		List<Proizvod> proz = pr.findAll();
		request.getSession().setAttribute("proizvodi", proz);
		return "kupac/pregledProzivodaKupac";
	}
	
	@GetMapping("getProizvodiAdmin")
	public String getKategorijeAdmin() {
		return "admin/pregledProizvodaAdmin";
	}
	
	@ModelAttribute("proizvodiAdmin")
	public List<Proizvod> getProizvodiAdmint(){
		return pr.findAll();
	}
	
	@GetMapping("getProizvod")
	public String getProizvod(@RequestParam("idP")Integer idProizvoda, HttpServletRequest request) {
		Proizvod p = pr.getReferenceById(idProizvoda);
		request.getSession().setAttribute("proizvod", p);
		return "kupac/proizvod";
	}
	
	@GetMapping("getProizvodAdmin")
	public String getProizvodAdmin(@RequestParam("idP")Integer idProizvoda, HttpServletRequest request) {
		Proizvod p = pr.getReferenceById(idProizvoda);
		request.setAttribute("proizvod", p);
		return "admin/pregledProizvodaAdmin";
	}
	
	@GetMapping("deleteProizvod")
	public String deleteProizvod(@RequestParam("idP")Integer idProizvoda) {
		Proizvod p = pr.getReferenceById(idProizvoda);
		pr.delete(p);
		return "admin/adminPage";
	}
	
    @PostMapping("savePodaci")
    public String savePodaci(Integer ocena, String omlijen, Integer kolicina, HttpServletRequest request, @AuthenticationPrincipal UserDetails userDetails) {
	    Korisnik trenutniKorisnik = kr.findByUsername(userDetails.getUsername());
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
    	System.out.println("Ovo je omiljen: " + omlijen);
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
    	if(kolicina > 0) {
			Porudzbina porudzbina = new Porudzbina();
			
    		if(trenutniKorisnik.getPorudzbina() == null) {
    	        System.out.println("Ovo je null");
    			Calendar calendar = Calendar.getInstance();
    	        Date currentDate = calendar.getTime();
    	        
    	        calendar.add(Calendar.DATE, 7);
    	        Date oneWeekLater = calendar.getTime();
    			
    	        porudzbina.setDatumNarucivanja(currentDate);
    	        porudzbina.setDatumIsporuke(oneWeekLater);
    	        porudzbina.setStatus("Naruceno");
    	        
    	        porudzbina.setKorisnik(trenutniKorisnik);
    		}else {
    			porudzbina = trenutniKorisnik.getPorudzbina();
    		}
			por.save(porudzbina);
			PorudzbinaHasProizvodPK phpk = new PorudzbinaHasProizvodPK();
			phpk.setPorudzbina_korisnik_username(trenutniKorisnik.getUsername());
			phpk.setProizvod_idProizvod(p.getIdProizvod());
			
			PorudzbinaHasProizvod php = new PorudzbinaHasProizvod();
			php.setId(phpk);
			php.setKolicina(kolicina);
			
			System.out.println("This is porudzbina " + porudzbina);
			
			porudzbina.addPorudzbinaHasProizvod(php);
			
			p.addPorudzbinaHasProizvod(php);
			
			trenutniKorisnik.setPorudzbina(porudzbina);

			phpr.save(php);
			por.save(porudzbina);
			kr.save(trenutniKorisnik);
			pr.save(p);
    	}
    	else {
			Porudzbina porudzbina = new Porudzbina();
    	    porudzbina.setKorisnik(trenutniKorisnik);
			PorudzbinaHasProizvodPK phpk = new PorudzbinaHasProizvodPK();
			phpk.setPorudzbina_korisnik_username(trenutniKorisnik.getUsername());
			phpk.setProizvod_idProizvod(p.getIdProizvod());
			
			PorudzbinaHasProizvod php = new PorudzbinaHasProizvod();
			php.setId(phpk);
			
			porudzbina.removePorudzbinaHasProizvod(php);
			
			p.removePorudzbinaHasProizvod(php);
			
			trenutniKorisnik.setPorudzbina(null);
			
			try {
				phpr.delete(php);
				por.delete(porudzbina);
				kr.save(trenutniKorisnik);
				pr.save(p);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
    	}
    	return "kupac/pregledProzivodaKupac";
    }
	
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
    	binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());  
    }
    
    @PostMapping("saveProizvod")
    public String saveProizvod(@ModelAttribute("proizvodDodat") Proizvod proizvod, HttpServletRequest request) {
		String poruka = "";
		try {
			Proizvod p = pr.save(proizvod);
			poruka += "Uspesno je sacuvan prozivod! Naziv proizvoda je: "+p.getIme();
		} catch(Exception e) {
			poruka += "Greska prilikom cuvanja proizvoda!";
		}
		request.setAttribute("porukaProzivod", poruka);
        return "admin/dodajProizvod";
    }
    
    @PostMapping("changeProizvod")
    public String changeProizvod(@ModelAttribute("proizvodDodat") Proizvod proizvod, HttpServletRequest request) {
		String poruka = "";
		Proizvod p = pr.getReferenceById(proizvod.getIdProizvod());
		try {
			if(!proizvod.getIme().equals("") && !p.getIme().equals(proizvod.getIme())) {
				p.setIme(proizvod.getIme());
			}
			if(p.getCena() != proizvod.getCena()) {
				p.setCena(proizvod.getCena());
			}
			System.out.println("ovo je slika " + proizvod.getSlika().length);
			if(proizvod.getSlika().length > 0 && !p.getSlika().equals(proizvod.getSlika())) {
				p.setSlika(proizvod.getSlika());
			}
			System.out.println("Ovo je opis " + proizvod.getOpis());
			if(!proizvod.getOpis().equals("") && !p.getOpis().equals(proizvod.getOpis())) {
				p.setOpis(proizvod.getOpis());
			}
			System.out.println("id popusta " + proizvod.getPopust());
			if(proizvod.getPopust() == null)
				p.setPopust(proizvod.getPopust());
			if(p.getPopust() == null || !p.getPopust().equals(proizvod.getPopust()))
				p.setPopust(proizvod.getPopust());
			if(!p.getKategorija().equals(proizvod.getKategorija()))
				p.setKategorija(proizvod.getKategorija());
			if(!p.getProizvodjac().equals(proizvod.getProizvodjac()))
				p.setProizvodjac(proizvod.getProizvodjac());
			pr.save(p);
			poruka += "Uspesno je promenjen prozivod! Naziv proizvoda je: "+p.getIme();
		} catch(Exception e) {
			poruka += "Greska prilikom menjanja proizvoda!";
		}
		request.setAttribute("porukaProzivod", poruka);
        return "admin/pregledProizvodaAdmin";
    }
    
}