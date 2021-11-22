package com.rios.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rios.dto.entity.PokemonDTO;
import com.rios.jpa.entity.PokemonJPA;
import com.rios.jpa.repository.PokemonRepository;
import com.rios.service.PokemonService;
import com.rios.util.Convertidor;

import java.util.List;
import java.util.Optional;

@Service("pokemonService")
public class PokemonServiceImpl implements PokemonService {

private static final Logger log = LogManager.getLogger(PokemonServiceImpl.class);
	
	@Autowired
	@Qualifier("repositorioPokemones")
	private PokemonRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	public boolean crear(PokemonDTO pokemon){
		try {
			log.info("ini: Guardar Pokemon");
			repositorio.save(new PokemonJPA(pokemon));
			
			return true;
		} catch (Exception e) {
			log.error("error al Guardar Pokemon "+e);
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean actualizar(PokemonDTO pokemon){
		try {
			log.info("ini: actualizar pokemon");
			repositorio.save(new PokemonJPA(pokemon));
			return true;
		} catch (Exception e) {
			log.error("error al Actualizar pokemon "+e);
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean borrar(long id){
		try {
			log.info("ini: borrar pokemon");
			Optional<PokemonJPA> nota = repositorio.findById(id);
			if(nota.isPresent()){
				repositorio.delete(nota.get());
			}else{
				log.error("id No existe");
				return false;
			}

			return true;
		} catch (Exception e) {
			log.error("error al Borrar pokemon "+e);
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public List<PokemonDTO> obtenerPokemones(){		
		List<PokemonJPA> pokes = repositorio.findAll();
		
		return convertidor.convertirLista(pokes);
	}
	
	public PokemonDTO getPokemonById(long id){		
		try {
			log.info("ini: getPokemonById pokemon");
			Optional<PokemonJPA> pokemon = repositorio.findById(id);
			if(pokemon.isPresent()){
				return new PokemonDTO(pokemon.get());
			}else{
				log.error("id No existe");
				return null;
			}

			
		} catch (Exception e) {
			log.error("error al obtener pokemon "+e);
			e.printStackTrace();
			return null;
		}
	}

}
