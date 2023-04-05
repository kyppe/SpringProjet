package com.example.projet.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Voiture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String color;
	private String marque;
	private String statut;
	private String description ;
	private String type;
	private double prix;
	@ManyToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	Vendeur vendeur;
	@OneToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	Vente vente;
	
	private String img;
	public Vendeur getVendeur() {
		return vendeur;
	}
	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}
	public Voiture(int id, String color, String marque, String type, String img, double prix, Vendeur vendeur,String statut,String description,
			Vente vente) {
		super();
		this.id = id;
		this.color = color;
		this.marque = marque;
		this.type = type;
		this.img = img;
		this.prix = prix;
		this.vendeur = vendeur;
		this.vente = vente;
		this.statut= statut ;
		this.description=description;
	}
	public String getStatut() {
		return statut;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}

	

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "Voiture [id=" + id + ", color=" + color + ", type=" + type + ", prix=" + prix + ", vendeur=" + vendeur
				+ ", vente=" + vente + "]";
	}



	public Voiture(int id, String color, String type, double prix) {

		this.id = id;
		this.color = color;
		this.type = type;
		this.prix = prix;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Voiture() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
