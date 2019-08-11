package com.br.zup.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.zup.models.Jogadores;
import com.br.zup.service.JogadoresService;
import com.br.zup.service.NumeroAleatorioService;

@Controller
public class NumeroAleatorioController {

	@Autowired
	private JogadoresService jogadoresService;

	@Autowired
	private NumeroAleatorioService numeroAleatorioService;

	@GetMapping("/")
	public ModelAndView mostrarTela() {
		ModelAndView modelAndView = new ModelAndView("inicio.html");
		modelAndView.addObject("ganhadores", jogadoresService.MostrarGanhadores());
		return modelAndView;
	}

	@GetMapping("/partida")
	public ModelAndView jogar() {
		ModelAndView modelAndView = new ModelAndView("jogar.html");
		return modelAndView;
	}

	@PostMapping("/partida")
	public ModelAndView salvarGanhador(@Valid Jogadores jogadores, BindingResult bindingJogador) {
		ModelAndView modelAndView = new ModelAndView("jogar.html");

		List<String> mensagens = new ArrayList<String>();
		List<String> erros = new ArrayList<String>();

		if (bindingJogador.hasErrors()) {

			for (ObjectError objectError : bindingJogador.getAllErrors()) {
				erros.add(objectError.getDefaultMessage());
				modelAndView.addObject("erros", erros);

			}

		} else {
			mensagens.add(numeroAleatorioService.salvarJogo(jogadores));
			modelAndView.addObject("mensagens", mensagens);
		}

		return modelAndView;

	}
}
