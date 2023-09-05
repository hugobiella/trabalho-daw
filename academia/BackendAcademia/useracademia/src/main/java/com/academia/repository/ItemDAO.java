package com.academia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.model.Item;

public interface ItemDAO extends JpaRepository<Item, Integer> {

}
