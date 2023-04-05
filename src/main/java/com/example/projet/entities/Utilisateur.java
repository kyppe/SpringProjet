package com.example.projet.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateur extends Personne{

	@OneToMany(cascade=CascadeType.ALL,fetch= FetchType.EAGER)
	private List<Vente> vente ;

	public List<Vente> getVente() {
		return vente;
	}

	public Utilisateur(List<Vente> vente) {
		super();
		this.vente = vente;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Utilisateur [vente=" + vente + "]";
	}

	public void setVente(List<Vente> vente) {
		this.vente = vente;
	}
}
