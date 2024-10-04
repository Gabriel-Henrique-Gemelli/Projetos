package com.Projetos.Memorizador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Projetos.Memorizador.Entitis.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

}
