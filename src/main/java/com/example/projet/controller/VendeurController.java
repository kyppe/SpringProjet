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


import com.example.projet.entities.Vendeur;
import com.example.projet.entities.Voiture;
import com.example.projet.services.ServicesVendeur;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vendeur")
public class VendeurController {

	
	@Autowired
	private  ServicesVendeur service ;
	
	@GetMapping()
	List<Vendeur>all()
	{
		return service.getAllVendeur();
	}
	
	@PostMapping("/login")
	Vendeur findByUsername(@RequestBody Vendeur v)
	{
		System.out.println(v.getUsername());
		Optional<Vendeur> vendeur=service.getVendeurbyUsername(v.getUsername());
		
		if (vendeur.isPresent())
		{
			Vendeur realVendeur =vendeur.get();
			System.out.println();
			if (realVendeur.getPassword().compareTo(v.getPassword())==0)	
			{
				return realVendeur ;
			}
				
		}
		return null;
	}
	
	@PostMapping()
	Vendeur add(@RequestBody Vendeur newVendeur)
	{
		
		return service.addEVendeur(newVendeur);
	}
	
	@GetMapping("/{id}")
	Optional<Vendeur> one(@PathVariable int id)
	{
		return service.getVendeur(id);
	}
	
	@PutMapping("/{id}")
	Vendeur replaceVoiture(@RequestBody Vendeur newVendeur ,@PathVariable int id )
	{
		System.out.println(newVendeur.getVoiture());
		 newVendeur.setId(id);
		 return service.updateVendeur(newVendeur, id);
	}
	@DeleteMapping("/{id}")
	void deleteVendeur(@PathVariable int id )
	{
		service.deleteVendeur(id);
	}

	
	
}
