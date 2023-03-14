package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteRepo {
	
	public void insertar(Estudiante estudiante);
	
	public List<Estudiante> buscarTodos();
	
	public Estudiante buscar(Integer id);
	
	public void eliminar(Integer id);
	
	public Estudiante buscarPorCedula(String cedula);

}
