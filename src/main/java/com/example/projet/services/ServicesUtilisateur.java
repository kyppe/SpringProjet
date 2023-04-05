package com.example.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.entities.Utilisateur;
import com.example.projet.entities.Vendeur;
import com.example.projet.repository.UtilisateurRepository;

@Service
public class ServicesUtilisateur {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	public List<Utilisateur> getAllUtilisateur() {
		return utilisateurRepository.findAll();
	}
	
	
	public Optional<Utilisateur> getUtilisateurbyUsername(String username)
	{
		return utilisateurRepository.findByUsername(username);
	}

	public Optional<Utilisateur> getUtilisateur(int id) {
		return utilisateurRepository.findById(id);
	}

	public Utilisateur addEUtilisateur(Utilisateur e) {
		return utilisateurRepository.save(e);
	}

	public void removeUtilisateur(int id) {
		utilisateurRepository.deleteById(id);
	}

	
	
	
	
	public Utilisateur updateUtilisateur(Utilisateur e, int id)

	{

		e.setId(id);

		utilisateurRepository.save(e);

		return utilisateurRepository.findById(id).get();

	}
	
}
