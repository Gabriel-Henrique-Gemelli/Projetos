package com.fabris.ControleSuaDiabetes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControleSuaDiabetesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleSuaDiabetesApplication.class, args); //Aqui inicia a aplicação 👍
		System.out.println("Lanche criado com sucesso");
	}
	
//    @Bean
//    CommandLineRunner init(UserRepository repo) {
//        return args -> {
//            User u = n ew User();
//            u.setNome("Gabriel");
//            u.setEmail("Lanche123");
//            repo.save(u);
//            System.out.println("Usuário salvo com sucesso!");
//        };
//    }
}
