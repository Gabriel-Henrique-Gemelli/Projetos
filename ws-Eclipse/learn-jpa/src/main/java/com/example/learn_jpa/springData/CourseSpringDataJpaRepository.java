package com.example.learn_jpa.springData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learn_jpa.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

	public List<Course> findByAuthor(String author);
	public List<Course> findByName(String name);
}
