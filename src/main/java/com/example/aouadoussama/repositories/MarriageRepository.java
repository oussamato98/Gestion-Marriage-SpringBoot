package com.example.aouadoussama.repositories;

import com.example.aouadoussama.entities.Marriage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarriageRepository extends JpaRepository<Marriage,Integer> {
}
