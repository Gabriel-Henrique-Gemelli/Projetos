package com.Gabriel.henrique.gemelli.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Gabriel.henrique.gemelli.financeiro.entity.Gastos;

@Repository
public interface GastosRepository extends JpaRepository<Gastos, Long>{

}
