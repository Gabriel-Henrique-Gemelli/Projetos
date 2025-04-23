package com.example.learn_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.learn_jpa.course.Course;
import com.example.learn_jpa.springData.CourseSpringDataJpaRepository;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
//
//	@Autowired
//	private CourseJpaRepository  repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.save(new Course(1,"Lanche123","Gemas"));
		repository.save(new Course(2,"Lanche123","Gemas"));
		repository.save(new Course(3,"Hiro de puta","Gemas"));
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		System.out.println(repository.findByAuthor("Gemas"));
		System.out.println(repository.findByAuthor("Gemas"));
		System.out.println(repository.findByName("Hiro de puta"));
	}

}
