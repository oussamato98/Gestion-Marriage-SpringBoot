package com.example.aouadoussama.repositories;

import com.example.aouadoussama.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Integer> {
}
