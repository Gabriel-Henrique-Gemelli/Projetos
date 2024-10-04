package com.Projetos.Memorizador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Projetos.Memorizador.Entitis.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
