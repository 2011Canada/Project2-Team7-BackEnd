package com.mixology.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mixology.models.Drinks;

public interface DrinksDAO  extends JpaRepository<Drinks, Integer>{
	


}
