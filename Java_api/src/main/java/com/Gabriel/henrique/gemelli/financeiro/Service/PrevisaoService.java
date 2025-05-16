package com.Gabriel.henrique.gemelli.financeiro.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Gabriel.henrique.gemelli.financeiro.DTO.PrevisaoResponse;

@Service
public class PrevisaoService {

	private final RestTemplate restTemplate;
	
	
	public PrevisaoService() {
		this.restTemplate = new RestTemplate();
	}
	
    public PrevisaoResponse obterPrevisao() {
        String url = "http://localhost:8000/previsao";
        return restTemplate.getForObject(url, PrevisaoResponse.class);
    }
}
