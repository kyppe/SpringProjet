package com.example.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.entities.Vendeur;
import com.example.projet.entities.Voiture;
import com.example.projet.repository.VendeurRepository;

@Service
public class ServicesVendeur {
	@Autowired
	private VendeurRepository vendeurRepository;
	
	public List<Vendeur> getAllVendeur() {
		return vendeurRepository.findAll();
	}

	public Optional<Vendeur> getVendeur(int id) {
		return vendeurRepository.findById(id);
	}

	public Optional<Vendeur> getVendeurbyUsername(String username)
	{
		return vendeurRepository.findByUsername(username);
	}
	
	public Vendeur addEVendeur(Vendeur e) {
		return vendeurRepository.save(e);
	}

	public void removeVendeur(int id) {
		vendeurRepository.deleteById(id);
	}

	
	
	
	public Vendeur updateVendeur(Vendeur e, int id)

	{

		e.setId(id);

		vendeurRepository.save(e);

		return vendeurRepository.findById(id).get();

	}
	public void deleteVendeur(int id)
	{
		vendeurRepository.deleteById(id);
	}
	public Vendeur VendeurDeleteVoiture(Voiture voiture)
	{
		Vendeur delVoiture = vendeurRepository.findByVoiture(voiture);
		delVoiture.delVoiture(voiture);
		return delVoiture;
	}
	
}
