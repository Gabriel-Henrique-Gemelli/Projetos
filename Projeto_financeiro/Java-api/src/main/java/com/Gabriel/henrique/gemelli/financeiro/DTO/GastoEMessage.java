package com.Gabriel.henrique.gemelli.financeiro.DTO;

import com.Gabriel.henrique.gemelli.financeiro.exception.ApiMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GastoEMessage<T> {

	private T Gastos;
	private ApiMessage message;

}
