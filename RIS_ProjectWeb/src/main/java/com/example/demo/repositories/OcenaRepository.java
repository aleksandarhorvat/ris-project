package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Ocena;
import model.OcenaPK;

public interface OcenaRepository extends JpaRepository<Ocena, OcenaPK>{
	
}
