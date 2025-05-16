package com.Gabriel.henrique.gemelli.financeiro.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gabriel.henrique.gemelli.financeiro.DTO.PrevisaoResponse;
import com.Gabriel.henrique.gemelli.financeiro.Service.PrevisaoService;

@RestController
@RequestMapping("/ia/previsao")
public class PrevisaoController {
	private final PrevisaoService service;

    public PrevisaoController(PrevisaoService service) {
        this.service = service;
    }

    @GetMapping
    public PrevisaoResponse previsao() {
        return service.obterPrevisao();
    }
}
