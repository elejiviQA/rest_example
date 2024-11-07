package com.example.rest_example.repository;

import com.example.rest_example.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {

}
