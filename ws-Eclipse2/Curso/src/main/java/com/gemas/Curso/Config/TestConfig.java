package com.gemas.Curso.Config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gemas.Curso.entities.Category;
import com.gemas.Curso.entities.Pedido;
import com.gemas.Curso.entities.User;
import com.gemas.Curso.entities.enums.PedidoStatus;
import com.gemas.Curso.repositories.CategoryRepository;
import com.gemas.Curso.repositories.PedidoRepository;
import com.gemas.Curso.repositories.UserRepositorie;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepositorie Repository;

	@Autowired
	private PedidoRepository RepositoryP;
	
	@Autowired
	private CategoryRepository RepositoryC;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PENDENTE, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.PENDENTE, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.PENDENTE, u1);
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");

		Repository.saveAll(Arrays.asList(u1, u2));
		RepositoryP.saveAll(Arrays.asList(o1, o2, o3));
		RepositoryC.saveAll(Arrays.asList(cat1,cat2,cat3));
	}
}
