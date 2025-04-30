package com.Gemas.demo_park_API;

import java.time.LocalDate;
import java.time.Period;

public class PessoaMapper {
	public static PessoaDto toDto(Pessoa pessoa) {
		int age = Period.between(pessoa.getDataNascimento(), LocalDate.now()).getYears();

		PessoaDto DTO = new PessoaDto();
		DTO.setNomeCompleto(pessoa.getNome() + pessoa.getSobrenome());
		DTO.setIdade((long)age);
		return DTO;
	}

}
