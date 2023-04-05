package com.example.projet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projet.entities.Voiture;
import com.example.projet.services.ServicesVendeur;
import com.example.projet.services.ServicesVoiture;






@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("voiture")
public class VoitureController {

	@Autowired
	private  ServicesVoiture service ;
	
	@Autowired
	private ServicesVendeur servicesVendeur;
	
	@GetMapping()
	List<Voiture>all()
	{
		return service.getAllVoiture();
	}
	
	@PostMapping()
	Voiture add(@RequestBody Voiture newVoiture)
	{
		return service.addEVoiture(newVoiture);
	}
	
	@GetMapping("/{id}")
	Optional<Voiture> one(@PathVariable int id)
	{
		return service.getVoiture(id);
	}
	
	@PutMapping("/{id}")
	Voiture replaceVoiture(@RequestBody Voiture newVoiture ,@PathVariable int id )
	{
		 newVoiture.setId(id);
		 
		 return service.updateVoiture(newVoiture, id);
	}
	@DeleteMapping("/{id}")
	void DeleteVoiture(@PathVariable int id )
	{
		Optional<Voiture> voiture = service.getVoiture(id);
		servicesVendeur.VendeurDeleteVoiture(voiture.get());

		service.deleteVoiture(id);
	}
	
	
}
