package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Proizvod;


public interface ProizvodRepository extends JpaRepository<Proizvod, Integer>{
	
}