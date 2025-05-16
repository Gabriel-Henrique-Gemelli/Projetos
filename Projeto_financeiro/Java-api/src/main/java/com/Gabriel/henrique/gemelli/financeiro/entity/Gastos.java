package com.Gabriel.henrique.gemelli.financeiro.entity;

import java.time.LocalDate;

import com.Gabriel.henrique.gemelli.financeiro.enun.CategoriaEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "gastos") 
public class Gastos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double valor;
	private String descricao;
	private LocalDate data;

	@Enumerated(EnumType.STRING)
	private CategoriaEnum categoria;
}
