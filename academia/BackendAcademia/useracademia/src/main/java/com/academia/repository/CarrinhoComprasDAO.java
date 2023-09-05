package com.academia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.model.CarrinhoCompras;

public interface CarrinhoComprasDAO extends JpaRepository<CarrinhoCompras, Integer> {

}
