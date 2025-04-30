package com.Gemas.demo_park_API;

public class PessoaDto {
	private String nomeCompleto;
	private long idade;

	public PessoaDto() {
	}

	public PessoaDto(String nomeCompleto, long idade) {
		this.nomeCompleto = nomeCompleto;
		this.idade = idade;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public long getIdade() {
		return idade;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public void setIdade(Long Idade) {
		this.idade = Idade;
	}

	@Override
	public String toString() {
		return "PessoaDto{" + "nomeCompleto='" + nomeCompleto + '\'' + ", idade=" + idade + '}';
	}
}
