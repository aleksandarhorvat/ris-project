package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Porudzbina;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, String>{

	@Query("select p from Porudzbina p where p.datumNarucivanja = :dateN")
	List<Porudzbina> getPorudzbineDatumNarucivanja(@Param("dateN")Date datumNarucivanja);
	
	@Query("select p from Porudzbina p where p.korisnik_username = :idK")
	Porudzbina getPorudzbinaKorisnika(@Param("idK")String username);
	
}