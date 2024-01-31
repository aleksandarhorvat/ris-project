package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Proizvod;


public interface ProizvodRepository extends JpaRepository<Proizvod, Integer>{
	
	@Query("select p from Proizvod p where p.kategorija.idKategorija = :idK")
	List<Proizvod> getProizvodiKategorije(@Param("idK")int idKategorija);
	
	@Query("select p from Proizvod p where p.proizvodjac.idProizvodjac = :idP")
	List<Proizvod> getProizvodiProzivodjaci(@Param("idP")int idProizvodjac);
	
}