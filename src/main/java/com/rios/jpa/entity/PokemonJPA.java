package com.rios.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rios.dto.entity.PokemonDTO;

@Entity
@Table(name = "tb_pokemon")
public class PokemonJPA implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="tipo")
	private String tipo;

	
	
	public PokemonJPA() {
	}
	
	public PokemonJPA(PokemonDTO poke) {
		this.id = poke.getId();
		this.nombre = poke.getNombre();
		this.tipo = poke.getTipo();

	}

	public PokemonJPA(long id, String nombre, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
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
	
}