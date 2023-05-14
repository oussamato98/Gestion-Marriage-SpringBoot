package com.example.aouadoussama.repositories;

import com.example.aouadoussama.entities.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteRepository extends JpaRepository<Societe,Integer> {
}
