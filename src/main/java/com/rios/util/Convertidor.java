package com.rios.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


import com.rios.dto.entity.PokemonDTO;
import com.rios.jpa.entity.PokemonJPA;

@Component("convertidor")
public class Convertidor{
	
	public List<PokemonDTO> convertirLista(List<PokemonJPA> listaJPA){
		List<PokemonDTO> lstPokemonModel = new ArrayList<>();
		
		for(PokemonJPA pokemon: listaJPA){
			lstPokemonModel.add(new PokemonDTO(pokemon));
		}
		
		return lstPokemonModel;
	}
	
	public PokemonDTO convertirDTO(PokemonJPA nota){
		return new PokemonDTO(nota);
	}

}