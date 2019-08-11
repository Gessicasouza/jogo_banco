package com.br.zup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.models.Jogadores;
import com.br.zup.repositories.JogadoresRepository;

@Service
public class JogadoresService {

	@Autowired
	private JogadoresRepository jogadoresRepository;

	public void salvarJogador(Jogadores jogadores) {
		jogadoresRepository.save(jogadores);
	}

	public Iterable<Jogadores> MostrarGanhadores() {
		return jogadoresRepository.findAll();
	}
}
