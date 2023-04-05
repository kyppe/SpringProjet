package com.example.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.projet.entities.Voiture;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Integer> {
	
}
