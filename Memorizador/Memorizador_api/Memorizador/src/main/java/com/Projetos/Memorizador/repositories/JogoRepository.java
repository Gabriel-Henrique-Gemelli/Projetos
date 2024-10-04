package com.Projetos.Memorizador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Projetos.Memorizador.Entitis.jogo;

@Repository
public interface JogoRepository extends JpaRepository<jogo, Long> {

}
