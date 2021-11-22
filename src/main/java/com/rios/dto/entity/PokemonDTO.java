package com.rios.dto.entity;

import com.rios.jpa.entity.PokemonJPA;

public class PokemonDTO {
	
	private long id;
	private String nombre;
	private String tipo;

	
	public PokemonDTO() {
	}


	public PokemonDTO(long id, String nombre, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
	}


	public PokemonDTO(PokemonJPA poke) {
		this.id = poke.getId();
		this.nombre = poke.getNombre();
		this.tipo = poke.getTipo();

	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "PokemonDTO [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}

}
