package Aplication;

import javax.persistence.*;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		Pessoa p = em.find(Pessoa.class, 2); // aqui elke busca no banco de dados
		em.getTransaction().begin();
		em.remove(p);// Aqui ele remove do banco de dados e sempre precisa de uma tranzaçao
		em.getTransaction().commit();
		/*
		 * Pessoa p1 = new Pessoa(null,"Carlos da silva", "carlos@gmail.com"); Pessoa p2
		 * = new Pessoa(null,"Augusto", "carlos@gmail.com"); Pessoa p3 = new
		 * Pessoa(null,"Lanche", "carlos@gmail.com");
		 * 
		 * 
		 * 
		 * em.getTransaction().begin(); em.persist(p1); // Aqui ele cria no banco de
		 * dados o que eu mandeiele criar em.persist(p2); em.persist(p3);
		 * em.getTransaction().commit(); System.out.println("Pronto!");
		 * 
		 * 
		 * System.out.println(p1); System.out.println(p2); System.out.println(p3);
		 */
	}

}
