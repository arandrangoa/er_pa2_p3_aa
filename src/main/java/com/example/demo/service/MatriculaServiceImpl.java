package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Materia;
import com.example.demo.modelo.Matricula;
import com.example.demo.repository.IMatriculaRepo;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private IMatriculaRepo iMatriculaRepo;
	
	@Autowired
	private IMateriaService iMateriaService;
	
	@Autowired
	private IEstudianteService estudianteService;

	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		Estudiante est=this.estudianteService.buscarPorCedula(matricula.getEstudiante().getCedula());
		Materia mat=this.iMateriaService.buscarPorCodigo(matricula.getMateria().getCodigo());
		int numeroEstuActual=mat.getNumeroEstudiantes();
		int numeroEstuNuevo=numeroEstuActual+1;
		mat.setNumeroEstudiantes(numeroEstuNuevo);
		this.iMateriaService.actualizar(mat);
		
		Matricula matri=new Matricula();
		matri.setEstudiante(est);
		matri.setMateria(mat);
		
		this.iMatriculaRepo.insertar(matri);
	}

	@Override
	public List<Matricula> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepo.buscarTodos();
	}

}
