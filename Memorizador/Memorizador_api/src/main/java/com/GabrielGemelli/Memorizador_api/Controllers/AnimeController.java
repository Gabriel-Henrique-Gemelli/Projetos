package com.GabrielGemelli.Memorizador_api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.GabrielGemelli.Memorizador_api.DTOs.AnimesDTO;
import com.GabrielGemelli.Memorizador_api.Entity.AnimesEntity;
import com.GabrielGemelli.Memorizador_api.Service.AnimeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/Anime")
public class AnimeController {

    private final AnimeService service;
    
    public AnimeController(AnimeService service) {
        super();
        this.service = service;
    }

    protected AnimesEntity ConvertDTOToEntity(AnimesDTO DTO) {
        AnimesEntity entity = new AnimesEntity();
        entity.setAutor(DTO.getAutor());
        entity.setTitulo(DTO.getTitulo());
        entity.setNota(DTO.getNota());
        entity.setQntEp(DTO.getQntEp());
        entity.setImageUrl(DTO.getImageUrl());

        return entity;
    }

    @PostMapping
    public ResponseEntity<AnimesEntity> postSave(@RequestBody AnimesDTO DTO) {
        AnimesEntity entity = ConvertDTOToEntity(DTO);

        try {
            service.save(entity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().header("Error",e.getMessage()).build();        
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
    
}