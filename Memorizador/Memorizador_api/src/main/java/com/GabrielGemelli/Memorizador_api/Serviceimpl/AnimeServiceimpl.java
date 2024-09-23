package com.GabrielGemelli.Memorizador_api.Serviceimpl;

import org.springframework.stereotype.Service;

import com.GabrielGemelli.Memorizador_api.Entity.AnimesEntity;
import com.GabrielGemelli.Memorizador_api.Repository.AnimeRepository;
import com.GabrielGemelli.Memorizador_api.Service.AnimeService;



@Service
public class AnimeServiceimpl implements AnimeService {

    private final AnimeRepository repository;
    public AnimeServiceimpl(AnimeRepository repository) {
        super();
        this.repository = repository;
    }

    // Aqui seria feito as validaçoes para saber se deu certo ou nao
    @Override
    public AnimesEntity save(AnimesEntity entity) throws Exception {
        repository.save(entity);
        return entity;
    }
}
