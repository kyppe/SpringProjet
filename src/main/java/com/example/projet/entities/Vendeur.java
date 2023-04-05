package com.example.projet.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Vendeur extends Personne {
@OneToMany(cascade=CascadeType.ALL,fetch= FetchType.EAGER)
List<Voiture> voiture;

public List<Voiture> getVoiture() {
	return voiture;
}

public void setVoiture(List<Voiture> voiture) {
	this.voiture = voiture;
}

public Vendeur() {
	super();
	// TODO Auto-generated constructor stub
}

public Vendeur(String username, String password) {
	super(username, password);
	// TODO Auto-generated constructor stub
}



public boolean delVoiture(Voiture voiture)
{
	return this.voiture.remove(voiture);
}

public Vendeur(List<Voiture> voiture) {
	super();
	this.voiture = voiture;
}

}
