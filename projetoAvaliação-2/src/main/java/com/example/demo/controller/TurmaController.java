package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Turma;
import com.example.demo.service.TurmaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Turma")

public class TurmaController {


	private final TurmaService turmaService;
	
	@Autowired
	public TurmaController (TurmaService turmaService) {
		
		this.turmaService = turmaService;
	}

	@GetMapping("/{id}")

	public ResponseEntity <Turma> buscaTurmaIdControlId(@PathVariable Long id){
		Turma Turma = turmaService.buscaTurmaId(id);
		
		if(Turma!= null) {
			return ResponseEntity.ok(Turma);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping

	public ResponseEntity<List<Turma>> buscaTodosTurmaControl() {
		List<Turma> Turma = turmaService.buscaTodosTurmas();

		return ResponseEntity.ok(Turma);
	}
	@PostMapping

	public ResponseEntity<Turma> salvaTurmaControl(@RequestBody @Valid Turma Turma){
		Turma salvaTurma = turmaService.salvaTurma(Turma);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTurma);
	}
	@PutMapping ("/{id}")

	public ResponseEntity<Turma> alterarCursos(@PathVariable Long id, @RequestBody @Valid Turma Turma) {
		Turma alterarTurma = turmaService.alterarTurma(id,Turma);

		if (alterarTurma  != null) {
			return ResponseEntity.ok(alterarTurma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")

	public ResponseEntity<String> apagaTurmaControl(@PathVariable Long id) {
		boolean apagar = turmaService.apagarTurma(id);

		if(apagar) {
           	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}

}