package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Kartica;
import model.KarticaPK;

public interface KarticaRepository extends JpaRepository<Kartica, KarticaPK>{

}