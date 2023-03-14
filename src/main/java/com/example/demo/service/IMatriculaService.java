package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Matricula;

public interface IMatriculaService {
	
	public void insertar(Matricula matricula);
	
	public List<Matricula> buscarTodos();

}
