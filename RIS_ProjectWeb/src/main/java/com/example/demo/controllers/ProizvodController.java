package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.ProizvodRepository;

import jakarta.servlet.http.HttpServletRequest;
import model.Proizvod;

@Controller
@RequestMapping(value="/proizvod/")
public class ProizvodController {
	
	@Autowired
	ProizvodRepository pr;
	
	@GetMapping("getProizvodi")
	public String getKategorije(HttpServletRequest request) {
		List<Proizvod> proz = pr.findAll();
		request.getSession().setAttribute("proizvodi", proz);
		return "pregledProizvoda";
	}
	
}