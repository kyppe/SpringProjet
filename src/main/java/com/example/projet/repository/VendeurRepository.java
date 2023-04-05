package com.example.projet.repository;

import java.util.Optional;

import com.example.projet.entities.Vendeur;
import com.example.projet.entities.Voiture;

import jakarta.transaction.Transactional;


@Transactional
public interface VendeurRepository extends PersonneRepository<Vendeur>{
	Vendeur findByVoiture(Voiture voiture);

}
