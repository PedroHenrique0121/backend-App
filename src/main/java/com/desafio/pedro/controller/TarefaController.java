package com.desafio.pedro.controller;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.desafio.pedro.entity.Tarefa;
import com.desafio.pedro.repository.TarefaRepository;
import com.desafio.pedro.service.TarefaService;

@RestController
@ComponentScan()

public class TarefaController {

	private TarefaService servico;

	public TarefaController(TarefaService servico) {

		this.servico = servico;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/tarefas")
	public List<Tarefa> listar() {
		return servico.listar();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/cadastrar")
	public ResponseEntity<?> criar(@RequestBody Tarefa tarefa) {

		return servico.criar(tarefa);
	}

	@RequestMapping(value = "/deletarTarefa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluir(@PathVariable(value = "id") int id) {
		return servico.excluir(id);
	}

	@RequestMapping(value = "/alterarTarefa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> alterar(@PathVariable(value = "id") int id, @RequestBody Tarefa tarefa) {

		return servico.alterar(id, tarefa);
	}

	@RequestMapping(value = "/buscarPorNome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorNome(@PathVariable(value = "nome") String nome) {

		return servico.buscarPorNome(nome);
	}

}
