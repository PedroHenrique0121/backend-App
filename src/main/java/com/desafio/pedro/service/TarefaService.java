package com.desafio.pedro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.desafio.pedro.entity.Tarefa;
import com.desafio.pedro.repository.TarefaRepository;

@Service
public class TarefaService {

	private TarefaRepository repositorio;

	public TarefaService(TarefaRepository repositorio) {
		this.repositorio = repositorio;
	}

	public ResponseEntity<Tarefa> criar( Tarefa tarefa) {
		repositorio.save(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED.value()).body(tarefa);

	}

	public ResponseEntity<?> excluir(int id) {

		Optional<Tarefa> tarefa = repositorio.findById(id);
		if (tarefa.isPresent()) {
			repositorio.delete(tarefa.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<?> alterar(int id, Tarefa tarefa) {

		Optional<Tarefa> nt = repositorio.findById((int) id);
		if (nt.isPresent()) {

			Tarefa c = nt.get();
			c.setDescricao(tarefa.getDescricao());
			c.setTitulo(tarefa.getTitulo());
			repositorio.save(c);
			return ResponseEntity.status(HttpStatus.OK.value()).body(c);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	public List<Tarefa> listar() {
		return repositorio.findAll();
		
	}

	public ResponseEntity<?> buscarPorNome(String nome) {

		List<Tarefa> lista = repositorio.findByDescricaoContaining(nome);
		if (lista.size() != 0) {
			return ResponseEntity.status(HttpStatus.OK.value()).body(lista);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(lista);
		}
	}
}
