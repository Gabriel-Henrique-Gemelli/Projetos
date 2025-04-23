package com.Gemas.Memorizador.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Gemas.Memorizador.entity.anime;

@Repository
public interface animeRepository extends JpaRepository<anime,Long>{

}
