package com.Projetos.Memorizador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Projetos.Memorizador.Entitis.Animes;


@Repository
public interface AnimeRepository extends JpaRepository<Animes, Long> {

}
