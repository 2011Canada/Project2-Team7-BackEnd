package com.mixology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mixology.models.Reviews;

public interface ReviewsDAO extends JpaRepository<Reviews, Integer>{

}
