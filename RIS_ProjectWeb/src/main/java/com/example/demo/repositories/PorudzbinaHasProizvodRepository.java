package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.PorudzbinaHasProizvod;
import model.PorudzbinaHasProizvodPK;

public interface PorudzbinaHasProizvodRepository extends JpaRepository<PorudzbinaHasProizvod, PorudzbinaHasProizvodPK>{

}
