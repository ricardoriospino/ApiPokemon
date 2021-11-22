package com.rios.service;

import java.util.List;

import com.rios.dto.entity.PokemonDTO;

public interface PokemonService {
	
	public boolean actualizar(PokemonDTO pokemon);
	
	public boolean borrar(long id);
	
	public List<PokemonDTO> obtenerPokemones();
	
	public PokemonDTO getPokemonById(long id);

}
