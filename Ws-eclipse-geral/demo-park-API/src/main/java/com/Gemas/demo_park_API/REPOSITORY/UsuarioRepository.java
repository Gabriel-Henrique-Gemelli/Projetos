package com.Gemas.demo_park_API.REPOSITORY;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Gemas.demo_park_API.ENTITY.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	Optional<Usuario> findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.nome = :nome")
	Optional<Usuario> findByNome(@Param("nome") String nome);
	
	@Query("SELECT u FROM Usuario u WHERE u.senha = :senha")
	Optional<Usuario> findBySenha(@Param("senha") String senha);

}
