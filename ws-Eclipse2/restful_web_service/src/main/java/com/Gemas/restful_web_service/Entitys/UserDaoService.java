package com.Gemas.restful_web_service.Entitys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int usercount = 0;

	static {
		users.add(new User(++usercount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usercount, "joao", LocalDate.now().minusYears(25)));
		users.add(new User(++usercount, "Lixo", LocalDate.now().minusYears(50)));
		users.add(new User(++usercount, "ALo", LocalDate.now().minusYears(60)));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		user.setId(++usercount);
		users.add(user);
		return user;
	}
	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElseThrow(() -> new IndexOutOfBoundsException("Nao foi possivel achar o Usuario com id: " + id));

	}

}
