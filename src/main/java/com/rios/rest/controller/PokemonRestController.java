package com.rios.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rios.dto.entity.PokemonDTO;
import com.rios.service.impl.PokemonServiceImpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin(origins ="http://localhost:4200",maxAge=3600) // anotacion para funcionamiento con Angular 
@RestController
@RequestMapping("/apiPokemon")
public class PokemonRestController {
	
private static final Logger log = LogManager.getLogger(PokemonRestController.class);
	
	@Autowired
	@Qualifier("pokemonService")
	private PokemonServiceImpl pokemonService;
	
	//http://localhost:8090/apiPokemon/listar
	@GetMapping("/listar")
	public List<PokemonDTO> obtenerPokemones(){
		System.out.println("ini: obtenerPokemones()");
		
		return pokemonService.obtenerPokemones();
	}
	
	
	//localhost:8090/apiPokemon/add
	
	@PostMapping("/add")
	public ResponseEntity<?> agregarPokemon(@RequestBody PokemonDTO pokemon){
		log.debug("ini: agregarPokemon()");
		
		boolean flag = pokemonService.crear(pokemon);
		
		if (flag)
		    return new ResponseEntity<>(HttpStatus.OK);
		else
		    return new ResponseEntity<>(HttpStatus.CONFLICT); //appropriate error code
	
	}
	
	//http://localhost:8090/apiPokemon/getPokemon/1
	@GetMapping("/getPokemon/{id}")
	public PokemonDTO obtenerPokemon(@PathVariable("id") long id){
		System.out.println("ini: obtenerPokemon()");
			
		return pokemonService.getPokemonById(id);
	}
		
	
	//localhost:8090/apiPokemon/update
	@PutMapping("/update")
	public ResponseEntity<?> actualizarPokemon( @RequestBody PokemonDTO pokemon){
		System.out.println("ini: actualizarPokemon()");
		boolean flag = pokemonService.actualizar(pokemon);
		
		if (flag)
		    return new ResponseEntity<>(HttpStatus.OK);
		else
		    return new ResponseEntity<>(HttpStatus.CONFLICT); //appropriate error code
	}
	
	
	//localhost:8090/apiPokemon/delete/1
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> borrarNota(@PathVariable("id") long id  ){
		System.out.println("ini: borrarNota()");
		
		boolean flag = pokemonService.borrar(id);
		
		if (flag)
		    return new ResponseEntity<>(HttpStatus.OK);
		else
		   return new ResponseEntity<>(HttpStatus.CONFLICT); //appropriate error code
	}
	
}
