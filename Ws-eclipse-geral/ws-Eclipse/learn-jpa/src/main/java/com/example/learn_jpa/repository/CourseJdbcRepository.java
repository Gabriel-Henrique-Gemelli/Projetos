package com.example.learn_jpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.learn_jpa.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springjdbcTemplate;
	
	private static String INSERT_QUERY = 
			"""
			
			insert into course (id,name,author)
			values(?,?,?)
			
			""";
	private static String DELETE_QUERY = 
			"""
			
			delete from course
			where id = (?)
			
			""";
	
	private static String SELECT_QUERY = 
			"""
			
			select * from course
			where id = ?
			
			""";
	
	public void insert(Course course) {
		springjdbcTemplate.update(INSERT_QUERY, course.getId(),course.getName(),course.getAuthor());
	}
	public void deleteById(int id) {
		springjdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById(long id) {
		return springjdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
		
	}
}
