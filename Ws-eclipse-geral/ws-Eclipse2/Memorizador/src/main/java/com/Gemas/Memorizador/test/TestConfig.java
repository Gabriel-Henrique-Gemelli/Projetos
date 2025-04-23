package com.Gemas.Memorizador.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Gemas.Memorizador.entity.anime;
import com.Gemas.Memorizador.repository.animeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	animeRepository repository;

	@Override
	public void run(String... args) throws Exception {
		List<String> nomes = List.of("One Piece", "Naruto", "Bleach", "Attack on Titan", "Demon Slayer");
		List<String> autores = List.of("Eiichiro Oda", "Masashi Kishimoto", "Tite Kubo", "Hajime Isayama",
				"Koyoharu Gotouge");
		Random random = new Random();

		anime a1 = new anime(nomes.get(random.nextInt(nomes.size())), autores.get(random.nextInt(autores.size())),
				LocalDate.of(random.nextInt(30) + 1990, random.nextInt(12) + 1, random.nextInt(28) + 1),
				random.nextInt(11));

		anime a2 = new anime(nomes.get(random.nextInt(nomes.size())), autores.get(random.nextInt(autores.size())),
				LocalDate.of(random.nextInt(30) + 1990, random.nextInt(12) + 1, random.nextInt(28) + 1),
				random.nextInt(11));

		anime a3 = new anime(nomes.get(random.nextInt(nomes.size())), autores.get(random.nextInt(autores.size())),
				LocalDate.of(random.nextInt(30) + 1990, random.nextInt(12) + 1, random.nextInt(28) + 1),
				random.nextInt(11));

		anime a4 = new anime(nomes.get(random.nextInt(nomes.size())), autores.get(random.nextInt(autores.size())),
				LocalDate.of(random.nextInt(30) + 1990, random.nextInt(12) + 1, random.nextInt(28) + 1),
				random.nextInt(11));

		anime a5 = new anime(nomes.get(random.nextInt(nomes.size())), autores.get(random.nextInt(autores.size())),
				LocalDate.of(random.nextInt(30) + 1990, random.nextInt(12) + 1, random.nextInt(28) + 1),
				random.nextInt(11));
		
		repository.saveAll(Arrays.asList(a1,a2,a3,a4,a5));

	}

}
