package com.mvp.easyhealth.pessoa.model;

import java.time.Instant;
import java.util.Objects;

import com.mvp.easyhealth.pessoa.dto.PessoaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_PESSOA")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_sequence")
	@SequenceGenerator(name = "pessoa_sequence", sequenceName = "pessoa_id_seq", allocationSize = 50)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NOME", nullable = false, length = 300)
	@NotNull
	@NotEmpty
	private String nome;
	
	@Column(name = "EMAIL", nullable = false, length = 100)
	@NotNull
	@NotEmpty
	private String email;
	
	@Column(name = "SENHA", nullable = true, length = 25)
	private String senha; //A V1 DO MVP NÃO TERÁ LOGIN. LOGO NÃO ESTÁ SENDO UTILIZADO NO MOMENTO
	
	@Column(name = "CRIADO_EM", nullable = false)
	private Instant criadoEm;
	

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
	
	public Instant getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Instant criadoEm) {
		this.criadoEm = criadoEm;
	}
	
	@PrePersist
	private void onPersist()
	{
		this.criadoEm = Instant.now();
	}
	
	public PessoaDTO toPessoaDto()
	{
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setId(this.id);
		pessoaDTO.setNome(this.nome);
		pessoaDTO.setEmail(this.email);
		return pessoaDTO;
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
