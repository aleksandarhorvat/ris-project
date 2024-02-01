package com.example.demo.controllers;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.KorisnikRepository;
import com.example.demo.repositories.PorudzbinaHasProizvodRepository;
import com.example.demo.services.EmailService;

import jakarta.servlet.http.HttpServletRequest;
import model.Korisnik;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/izvestaj/")
public class IzvestajController {
	
	@Autowired
	KorisnikRepository kr;
	
	@Autowired
	PorudzbinaHasProizvodRepository phpr;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping("kreirajIzvestaj")
	public String kreirajIzvestaj(Integer idKnjige, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) throws Exception {
		try {
			Korisnik k = kr.findByUsername(userDetails.getUsername());
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(phpr.getPorudzbinaZaKorisnika(k.getUsername()));
			InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/Racun.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
			Map<String, Object> params = new HashMap<String, Object>();
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
			inputStream.close();
			
			if (jasperPrint != null)
				emailService.sendEmailWithAttachment("r3366819@gmail.com", "aca.horvat.42@gmail.com", "racun", "vas racun", jasperPrint);
		}catch (Exception e) {
			return "kupacPage";
		}
		return "kupacPage";
	}
	
}