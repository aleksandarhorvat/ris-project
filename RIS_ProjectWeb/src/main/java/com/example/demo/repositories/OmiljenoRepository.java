package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Omiljeno;
import model.OmiljenoPK;

public interface OmiljenoRepository extends JpaRepository<Omiljeno, OmiljenoPK>{
	@Query("select o from Omiljeno o where o.id.korisnik_username = :idK")
	List<Omiljeno> getOmiljeniZaKorisnika(@Param("idK")String user);
	
}
