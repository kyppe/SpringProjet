package com.example.projet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.projet.entities.Personne;
import com.example.projet.entities.Vendeur;


@NoRepositoryBean
public interface PersonneRepository <T extends Personne> extends JpaRepository<T , Integer>{
	<T extends Personne>Optional<T> findByUsername(String username);
}
