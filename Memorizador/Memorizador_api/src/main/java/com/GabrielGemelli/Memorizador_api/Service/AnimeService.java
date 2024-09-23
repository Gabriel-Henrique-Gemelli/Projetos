package com.GabrielGemelli.Memorizador_api.Service;

import com.GabrielGemelli.Memorizador_api.Entity.AnimesEntity;

public interface AnimeService {
    AnimesEntity save(AnimesEntity entity) throws Exception;
}
