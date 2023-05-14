package com.example.aouadoussama.repositories;

import com.example.aouadoussama.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteRepository extends JpaRepository<Poste,Integer> {
}
