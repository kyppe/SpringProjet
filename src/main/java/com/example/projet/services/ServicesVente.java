package com.example.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.entities.Vente;

import com.example.projet.repository.VenteRepository;
@Service
public class ServicesVente {

	@Autowired
	private VenteRepository venteRepository;
	
	public List<Vente> getAllVente() {
		return venteRepository.findAll();
	}

	public Optional<Vente> getVente(int id) {
		return venteRepository.findById(id);
	}

	public Vente addVente(Vente e) {
		return venteRepository.save(e);
	}

	public void removeVente(int id) {
		venteRepository.deleteById(id);
	}

	public Vente updateVente(Vente e, int id)

	{

		e.setId(id);

		venteRepository.save(e);

		return venteRepository.findById(id).get();

	}
}
