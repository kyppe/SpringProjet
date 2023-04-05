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

import com.example.projet.entities.Vente;

import com.example.projet.services.ServicesVente;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("vente")
public class VenteController {

	
	@Autowired
	private  ServicesVente service ;
	
	@GetMapping()
	List<Vente>all()
	{
		return service.getAllVente();
	}
	
	@PostMapping()
	Vente add(@RequestBody Vente newVente)
	{
		return service.addVente(newVente);
	}
	
	@GetMapping("/{id}")
	Optional<Vente> one(@PathVariable int id)
	{
		return service.getVente(id);
	}
	
	@PutMapping("/{id}")
	Vente replaceVente(@RequestBody Vente newVente ,@PathVariable int id )
	{
		 newVente.setId(id);
		 return service.updateVente(newVente, id);
	}
	@DeleteMapping("/{id}")
	void deleteVente(@PathVariable int id)
	{
		service.removeVente(id);
	}
	
}
