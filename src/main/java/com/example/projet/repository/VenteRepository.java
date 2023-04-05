package com.example.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projet.entities.Vente;

@Repository
public interface VenteRepository extends JpaRepository<Vente,Integer>{
	
}
