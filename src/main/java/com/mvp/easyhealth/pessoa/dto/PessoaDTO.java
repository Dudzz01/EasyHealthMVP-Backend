package com.mvp.easyhealth.pessoa.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvp.easyhealth.pessoa.model.Pessoa;

public class PessoaDTO {
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;
	

	private String nome;
	

	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String senha; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public Pessoa toPessoa()
	{
		Pessoa pessoa = new Pessoa();
		
		if(this.id != null)
		{
			pessoa.setId(this.id);
		}
		
		pessoa.setNome(this.nome);
		pessoa.setEmail(this.email);
		return pessoa;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		
		if(obj == null || this.getClass() != obj.getClass())
		{
			return false;
		}
		
		Pessoa pessoa = (Pessoa) obj;
		
		return Objects.equals(this.id, pessoa.getId());
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(this.id);
	}
	
	
}
