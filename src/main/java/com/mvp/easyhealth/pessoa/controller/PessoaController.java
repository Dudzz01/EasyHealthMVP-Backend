package com.mvp.easyhealth.pessoa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvp.easyhealth.pessoa.dto.PessoaDTO;
import com.mvp.easyhealth.pessoa.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<PessoaDTO> criar(@RequestBody PessoaDTO pessoaDTO) 
	{ 
		PessoaDTO pessoaRetorno = this.pessoaService.criar(pessoaDTO); 
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaRetorno); 
	}
	
	
	
	@PutMapping("/{id}") 
	public ResponseEntity<PessoaDTO> atualizar(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) 
	{ 
		PessoaDTO pessoaRetorno = this.pessoaService.atualizar(id, pessoaDTO); 
		return ResponseEntity.status(HttpStatus.OK).body(pessoaRetorno); 
	}
	
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<PessoaDTO> buscarPessoa(@PathVariable Long id)
	{
		PessoaDTO pessoaRetorno = this.pessoaService.buscarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(pessoaRetorno);
	}

}
