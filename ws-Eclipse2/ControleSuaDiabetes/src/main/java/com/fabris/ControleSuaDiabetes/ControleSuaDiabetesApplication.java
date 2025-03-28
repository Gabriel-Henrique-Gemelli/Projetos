package com.fabris.ControleSuaDiabetes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fabris.ControleSuaDiabetes.entity.User;
import com.fabris.ControleSuaDiabetes.repository.UserRepository;

@SpringBootApplication
public class ControleSuaDiabetesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleSuaDiabetesApplication.class, args);
		System.out.println("Lanche criaod com sucesso");
	}
	
//    @Bean
//    CommandLineRunner init(UserRepository repo) {
//        return args -> {
//            User u = new User();
//            u.setNome("Gabriel");
//            u.setEmail("Lanche123");
//            repo.save(u);
//            System.out.println("Usuário salvo com sucesso!");
//        };
//    }
}
