package com.Projetos.Memorizador.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Projetos.Memorizador.Entitis.Animes;
import com.Projetos.Memorizador.Entitis.User;
import com.Projetos.Memorizador.repositories.AnimeRepository;
import com.Projetos.Memorizador.repositories.JogoRepository;
import com.Projetos.Memorizador.repositories.LivroRepository;
import com.Projetos.Memorizador.repositories.SerieRepository;
import com.Projetos.Memorizador.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository Repository;
	@Autowired
	private AnimeRepository RepositoryA;
	@Autowired
	private JogoRepository RepositoryJ;
	@Autowired
	private SerieRepository Repositorys;
	@Autowired
	private LivroRepository Repositoryl;

	@Override
	public void run(String... args) throws Exception {
		
		List<User> usuarios1 = new ArrayList<>();
		List<User> usuarios2 = new ArrayList<>();
		User u1 = new User("Maria Brown", "maria@gmail.com");
		User u2 = new User("Alex Green", "alex@gmail.com"); 


		// Adicionar usuários às listas (exemplo)
		usuarios1.add(new User("Gabriel", "senha123"));
		usuarios2.add(new User("Henrique", "senha456", null, null, null, null));
		
		Animes naruto = new Animes("Naruto", 220, 9, "link_para_imagem_naruto.jpg", usuarios1);
		Animes onePiece = new Animes("One Piece", 1000, 10, "link_para_imagem_onepiece.jpg", usuarios1);
		Animes bleach = new Animes("Bleach", 366, 8, "link_para_imagem_bleach.jpg", usuarios1);
		
		Repository.saveAll(Arrays.asList(u1,u2));
		RepositoryA.saveAll(Arrays.asList(naruto,onePiece,bleach));
		
	}

}
