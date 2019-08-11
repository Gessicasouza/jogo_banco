package com.br.zup.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class NumeroAleatorio implements Serializable {
	private static final long serilVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private Integer numero;

	@OneToOne(mappedBy = "numeroAleatorio")
	private Jogadores jogadores;

	public NumeroAleatorio() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Jogadores getJogadores() {
		return jogadores;
	}

	public void setJogadores(Jogadores jogadores) {
		this.jogadores = jogadores;
	}

}
