package com.academia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.model.Plano;

public interface PlanoDAO extends JpaRepository<Plano, Integer> {

}
