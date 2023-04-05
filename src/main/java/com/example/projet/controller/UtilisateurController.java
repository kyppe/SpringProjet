package com.example.projet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projet.entities.Utilisateur;
import com.example.projet.entities.Vendeur;
import com.example.projet.services.ServicesUtilisateur;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("utilisateur")
public class UtilisateurController {

	
	@Autowired
	private  ServicesUtilisateur service ;
	
	@GetMapping()
	List<Utilisateur>all()
	{
		return service.getAllUtilisateur();
	}
	
	
	
	@PostMapping("/login")
	Utilisateur findByUsername(@RequestBody Utilisateur v)
	{
		System.out.println(v.getUsername());
		Optional<Utilisateur> utilisateur=service.getUtilisateurbyUsername(v.getUsername());
		System.out.println(utilisateur.isPresent());
		if (utilisateur.isPresent())
		{
			Utilisateur realUtilisateur =utilisateur.get();
			System.out.println();
			if (realUtilisateur.getPassword().compareTo(v.getPassword())==0)	
			{
				return realUtilisateur ;
			}
				
		}
		return null;
	}
	
	
	@PostMapping()
	Utilisateur add(@RequestBody Utilisateur newUtilisateur)
	{
		return service.addEUtilisateur(newUtilisateur);
	}
	
	@GetMapping("/{id}")
	Optional<Utilisateur> one(@PathVariable int id)
	{
		return service.getUtilisateur(id);
	}
	
	@PutMapping("/{id}")
	Utilisateur replaceVoiture(@RequestBody Utilisateur newUtilisateur ,@PathVariable int id )
	{
		newUtilisateur.setId(id);
		 return service.updateUtilisateur(newUtilisateur, id);
	}

	
}
