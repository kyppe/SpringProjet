package com.example.projet.repository;

import com.example.projet.entities.Utilisateur;

import jakarta.transaction.Transactional;

@Transactional
public interface UtilisateurRepository extends PersonneRepository<Utilisateur> {

}
