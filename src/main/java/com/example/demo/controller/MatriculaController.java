package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Matricula;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@GetMapping("/registrarMatricula")
	public String registrarMatricula(Matricula matricula) {
		return"vistaNuevaMatricula";
	}
	
	@PostMapping("/insertar")
	public String insertarMatricula(Matricula matricula) {
		this.iMatriculaService.insertar(matricula);
		return "redirect:/matriculas/listaMatriculas";
	}
	
	@GetMapping("/listaMatriculas")
	public String listaMatriculas(Model modelo) {
		List<Matricula> matriculas=this.iMatriculaService.buscarTodos();
		modelo.addAttribute("matriculas", matriculas);
		return "vistaListaMatriculas";
	}

}
