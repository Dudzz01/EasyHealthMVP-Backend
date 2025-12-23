package com.mvp.easyhealth.exceptions;



@SuppressWarnings("serial")
public class PessoaInexistenteException extends RuntimeException {
	


	public PessoaInexistenteException(String mensagem)
	{
		super(mensagem);
	}

}
