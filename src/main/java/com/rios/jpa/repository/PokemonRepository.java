package com.rios.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rios.jpa.entity.PokemonJPA;

@Repository("repositorioPokemones")
public interface PokemonRepository extends JpaRepository<PokemonJPA, Serializable> {
	
	
	public PokemonJPA findByNombreAndId(String vnombre, long vid);
	

}
