package com.Gemas.restful_web_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Gemas.restful_web_service.Entitys.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
