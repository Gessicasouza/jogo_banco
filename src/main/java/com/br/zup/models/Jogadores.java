package com.br.zup.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Jogadores implements Serializable {
	private static final long serilVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Nome é obrigatorio")
	private String nome;

	@DecimalMin(value = "1", message = "Digite um numero entre 1 e 5")
	private Integer numeroChute;

	@OneToOne(cascade = { CascadeType.ALL })
	private NumeroAleatorio numeroAleatorio;

	public Jogadores() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroChute() {
		return numeroChute;
	}

	public void setNumeroChute(Integer numeroChute) {
		this.numeroChute = numeroChute;
	}

	public NumeroAleatorio getNumeroAleatorio() {
		return numeroAleatorio;
	}

	public void setNumeroAleatorio(NumeroAleatorio numeroAleatorio) {
		this.numeroAleatorio = numeroAleatorio;
	}

}
