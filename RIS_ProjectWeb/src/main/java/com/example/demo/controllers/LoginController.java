package com.example.demo.controllers;

import com.example.demo.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    KorisnikRepository kr;

    @GetMapping("getLoginPage")
    public String getLoginPage() {
        return "logIn";
    }

//    @PostMapping("saveLogin")
//    public String saveLogin(String username, String password, HttpServletRequest request) {
//        // Perform authentication logic
//        Korisnik korisnik = kr.findById(username).orElse(null);
//        
//        if (korisnik != null && korisnik.getPassword().equals(password)) {
//    		request.getSession().setAttribute("trenutniKorisnik", korisnik);
//        	if(korisnik.getUloga().getNaziv().equals("Kupac"))
//        		return "kupacPage";
//        	else
//        		return "adminPage";
//
//        }
//        else
//    		request.setAttribute("error", "Niste uspeli da se ulogujete!");
//        
//        return "logIn";
//    }
    
    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMINISTRATOR")) {
            return "adminPage";
        }
        return "kupacPage";
    }
}
