package com.academia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

}
