package com.Projetos.Memorizador.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Projetos.Memorizador.Entitis.Animes;
import com.Projetos.Memorizador.Entitis.User;
import com.Projetos.Memorizador.Entitis.jogo;
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

		Animes naruto = new Animes("Naruto", 220, 9, "link_para_imagem_naruto.jpg");
		Animes onePiece = new Animes("One Piece", 1000, 10, "link_para_imagem_onepiece.jpg");
		Animes bleach = new Animes("Bleach", 366, 8, "link_para_imagem_bleach.jpg");

		List<Animes> animes = Arrays.asList(naruto, onePiece, bleach);
		RepositoryA.saveAll(Arrays.asList(naruto, onePiece, bleach));

		jogo gtaV = new jogo("GTA V", 24, 10, "Blah Blah Blah");
		jogo theWitcher = new jogo("The Witcher 3", 26, 9, "Blah Blah Blah");
		jogo zelda = new jogo("The Legend of Zelda", 10, 10, "Blah Blah Blah");

		List<jogo> jogo = Arrays.asList(gtaV, theWitcher, zelda);
		RepositoryJ.saveAll(Arrays.asList(gtaV, theWitcher, zelda));

		User u1 = new User("Maria Brown", "maria@gmail.com", animes, null, null, jogo);
		User u2 = new User("Alex Green", "alex@gmail.com");
		User u3 = new User("Gabriel", "senha123");
		User u4 = new User("Henrique", "senha456");

		Repository.saveAll(Arrays.asList(u1, u2, u3, u4));
		Repository.flush();

		// Adicionar usuários às listas (exemplo)

	}

}
