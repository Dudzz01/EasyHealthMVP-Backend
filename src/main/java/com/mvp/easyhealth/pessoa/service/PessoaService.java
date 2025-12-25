package com.mvp.easyhealth.pessoa.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvp.easyhealth.exceptions.PessoaInexistenteException;
import com.mvp.easyhealth.pessoa.dto.PessoaDTO;
import com.mvp.easyhealth.pessoa.model.Pessoa;
import com.mvp.easyhealth.pessoa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	private PessoaRepository pessoaRepository;
	
	
	public PessoaService(PessoaRepository pessoaRepository)
	{
		this.pessoaRepository = pessoaRepository;
	}
	
	@Transactional
	public PessoaDTO criar(PessoaDTO pessoaDto)
	{
		pessoaDto.setId(null);
		
		
		Pessoa pessoa = pessoaDto.toPessoa();
		pessoa = pessoaRepository.save(pessoa);
		
		pessoaDto = pessoa.toPessoaDto();
		
		return pessoaDto;
		
	}
	
	@Transactional
	public PessoaDTO atualizar(Long id, PessoaDTO pessoaDto)
	{
		Pessoa pessoa = this.buscarPorIdRetornoEntity(id);
		
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setEmail(pessoaDto.getEmail());
		
		pessoa = pessoaRepository.save(pessoa);
		
		pessoaDto = pessoa.toPessoaDto();
		
		return pessoaDto; 
	}
	
	public PessoaDTO buscarPorId(Long id)
	{
			Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new PessoaInexistenteException("Erro ao encontrar a respectiva conta no sistema. Tente novamente mais tarde."));
			return pessoa.toPessoaDto();
	}
	
	
	private Pessoa buscarPorIdRetornoEntity(Long id)
	{
			Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new PessoaInexistenteException("Erro ao encontrar a respectiva conta no sistema. Tente novamente mais tarde."));
			return pessoa;
	}
	
	public PessoaDTO buscarPorEmail(String email)
	{
			Pessoa pessoa = pessoaRepository.findByEmail(email).orElseThrow(() -> new PessoaInexistenteException("Email não encontrado."));
			return pessoa.toPessoaDto();
	}
	
	public PessoaDTO buscarPorEmailParaGerarRelatorio(String email)
	{
			Pessoa pessoa = pessoaRepository.findByEmail(email).orElse(null);
			
			if(pessoa == null)
			{
				return null;
			}
			
			return pessoa.toPessoaDto();
	}
	
	

}
