package com.example.projet.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Vente {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	@OneToOne(cascade=CascadeType.ALL,fetch= FetchType.EAGER)
	Voiture voiture;
	private LocalDate dateVente;
	@ManyToOne(cascade=CascadeType.ALL,fetch= FetchType.EAGER)
	
	Utilisateur utilisateur ;
	public Vente(int id, Voiture voiture, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.voiture = voiture;
		this.utilisateur = utilisateur;
	}
	public Vente()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public LocalDate getDateVente() {
		return dateVente;
	}
	public void setDateVente(LocalDate dateVente) {
		this.dateVente = dateVente;
	}


}
