package com.Gemas.demo_park_API.config;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class SpringTimeZoneConfig {

	@PostConstruct
	public void TimeZoneConfig() {
		System.setProperty("user.timezone", "America/Sao_Paulo");
		try {
			java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("America/Sao_Paulo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Timezone set to America/Sao_Paulo");
	}
}
