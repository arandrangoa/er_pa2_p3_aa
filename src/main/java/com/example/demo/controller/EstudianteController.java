package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping("/registrarEstudiante")
	public String registrarEstudiante(Estudiante estudiante) {
		return "vistaNuevoEstudiante";
	}
	
	@PostMapping("/insertar")
	public String insertarEstudiante(Estudiante estudiante) {
		this.estudianteService.insertar(estudiante);
		return "redirect:/estudiantes/listaEstudiantes";
	}
	
	@GetMapping("/listaEstudiantes")
	public String listaEstudiantes(Model modelo) {
		List<Estudiante> estudiantes=this.estudianteService.buscarTodos();
		modelo.addAttribute("estudiantes", estudiantes);
		return "vistalistaEstudiantes";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarEstudiante(@PathVariable("id")Integer id) {
		this.estudianteService.eliminar(id);
		return"redirect:/estudiantes/listaEstudiantes";
	}

}
