package com.Projetos.Memorizador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Projetos.Memorizador.Entitis.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
