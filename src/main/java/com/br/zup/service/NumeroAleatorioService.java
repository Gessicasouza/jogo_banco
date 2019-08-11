package com.br.zup.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.models.Jogadores;
import com.br.zup.models.NumeroAleatorio;
import com.br.zup.repositories.JogadoresRepository;
import com.br.zup.repositories.NumerosAleatoriosRepository;

@Service
public class NumeroAleatorioService {

	@Autowired
	private JogadoresRepository jogadoresRepository;

	@Autowired
	private NumerosAleatoriosRepository numerosAleatoriosRepository;

	public String salvarJogo(Jogadores jogadores) {

		NumeroAleatorio partida = new NumeroAleatorio();
		Random random = new Random();
		int numero = 1 + random.nextInt(5);
		String mensagen = "";

		if (jogadores.getNumeroChute() == numero) {
			partida.setNumero(numero);
			partida.setJogadores(jogadores);
			jogadores.setNumeroAleatorio(partida);
			jogadoresRepository.save(jogadores);

			mensagen = "Parabéns vc ganhou\nNumero jogado " + jogadores.getNumeroChute() + " numero sortiado" + numero;
		} else {
			mensagen = "Não foi desta vez\nNumero jogado " + jogadores.getNumeroChute() + " numero sortiado" + numero;
		}

		return mensagen;
	}
}
