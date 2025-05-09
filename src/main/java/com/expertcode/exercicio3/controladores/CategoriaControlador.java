package com.expertcode.exercicio3.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expertcode.exercicio3.entidades.DTO.CategoriaDTO;
import com.expertcode.exercicio3.servicos.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaControlador {

	@Autowired
	private CategoriaServico servico;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id){
		CategoriaDTO obj = servico.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> buscarTodos(){
		List<CategoriaDTO> Categorias = servico.buscarTodos();
		return ResponseEntity.ok().body(Categorias);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}
}
