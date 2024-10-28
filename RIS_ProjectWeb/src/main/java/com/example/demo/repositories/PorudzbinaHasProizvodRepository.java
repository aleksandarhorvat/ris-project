package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.PorudzbinaHasProizvod;
import model.PorudzbinaHasProizvodPK;

public interface PorudzbinaHasProizvodRepository extends JpaRepository<PorudzbinaHasProizvod, PorudzbinaHasProizvodPK>{
	@Query("select p from PorudzbinaHasProizvod p where p.id.porudzbina_korisnik_username = :idK")
	List<PorudzbinaHasProizvod> getPorudzbinaZaKorisnika(@Param("idK")String user);
}
