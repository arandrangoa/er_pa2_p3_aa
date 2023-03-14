package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Matricula;

public interface IMatriculaRepo {
	
	public void insertar(Matricula matricula);
	
	public List<Matricula> buscarTodos();

}
