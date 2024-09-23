package com.GabrielGemelli.Memorizador_api.Repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GabrielGemelli.Memorizador_api.Entity.AnimesEntity;

@Repository
public interface AnimeRepository extends JpaRepository<AnimesEntity, UUID> {

}
