package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Materia;
import com.example.demo.repository.IMateriaRepo;

@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private IMateriaRepo iMateriaRepo;

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		materia.setNumeroEstudiantes(0);
		this.iMateriaRepo.insertar(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iMateriaRepo.buscarPorCodigo(codigo);
	}

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepo.actualizar(materia);
	}

}
