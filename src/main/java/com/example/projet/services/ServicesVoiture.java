package com.example.projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.entities.Voiture;
import com.example.projet.repository.VoitureRepository;


@Service
public class ServicesVoiture {
	@Autowired
	private VoitureRepository voitureRepository;
	
	public List<Voiture> getAllVoiture() {
		return voitureRepository.findAll();
	}

	public Optional<Voiture> getVoiture(int id) {
		return voitureRepository.findById(id);
	}

	public Voiture addEVoiture(Voiture e) {
		return voitureRepository.save(e);
	}

	public void deleteVoiture(int id )
	{
		 voitureRepository.deleteById(id);
	}
	public void removeVoiture(int id) {
		voitureRepository.deleteById(id);
	}

	
	
	
	
	public Voiture updateVoiture(Voiture e, int id)

	{

		e.setId(id);

		voitureRepository.save(e);

		return voitureRepository.findById(id).get();

	}

	

}
