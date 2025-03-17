package Aplication;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(1,"Carlos da silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(1,"Augusto", "carlos@gmail.com");
		Pessoa p3 = new Pessoa(1,"Lanche", "carlos@gmail.com");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

}
