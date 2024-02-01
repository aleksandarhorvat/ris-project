package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, String>{

	@Query("select k from Korisnik k where k.username = :username")
	public Korisnik findByUsername(@Param("username") String username);
	
}
