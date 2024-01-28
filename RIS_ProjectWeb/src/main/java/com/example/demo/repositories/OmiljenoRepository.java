package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Omiljeno;
import model.OmiljenoPK;

public interface OmiljenoRepository extends JpaRepository<Omiljeno, OmiljenoPK>{
	
}
