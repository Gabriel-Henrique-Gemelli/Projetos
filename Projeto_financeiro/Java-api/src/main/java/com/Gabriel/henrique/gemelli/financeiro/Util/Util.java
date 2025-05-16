package com.Gabriel.henrique.gemelli.financeiro.Util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Gabriel.henrique.gemelli.financeiro.entity.Gastos;
import com.Gabriel.henrique.gemelli.financeiro.repository.GastosRepository;

import lombok.RequiredArgsConstructor;

@RequestMapping("/extrato")
@RequiredArgsConstructor
public class Util {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private final GastosRepository repository;

	@GetMapping
	public void Extrato() {

		List<Gastos> gastos = repository.findAll();

		try (FileWriter writer = new FileWriter("extrato" + ".csv")) {
			writer.write("Data; Categoria; Valor; Esornado \n");
			for (Gastos g : gastos) {
				writer.write(formatter.format(g.getData()) + "; " + g.getCategoria() + "; " + g.getValor() + "; "
						+ g.getDescricao() + "\n");
			}
			System.out.println("✅ Extrato criando com sucesso.");
		} catch (IOException e) {
			System.err.println("❎ Erro ao gerar extrato: " + e.getMessage());
		}
	}
}
