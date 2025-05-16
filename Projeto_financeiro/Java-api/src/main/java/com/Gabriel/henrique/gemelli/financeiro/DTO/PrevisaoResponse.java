package com.Gabriel.henrique.gemelli.financeiro.DTO;

import java.util.Map;

public class PrevisaoResponse {
	private Map<String, Double> previsoes;

    public Map<String, Double> getPrevisoes() {
        return previsoes;
    }

    public void setPrevisoes(Map<String, Double> previsoes) {
        this.previsoes = previsoes;
    }
}
