package com.example.aouadoussama.controllers;


import com.example.aouadoussama.entities.Personne;
import com.example.aouadoussama.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "personne")
public class PersonneController {
    @Autowired
    PersonneRepository personneRepository;

    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
    @GetMapping
    ResponseEntity<List<Personne>> getPersonnes(){

        List<Personne> personneList = personneRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(personneList);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @PostMapping
    ResponseEntity<Personne> addPersonne(@RequestBody Personne personne){

        Personne p = new Personne();
        p.setNom(personne.getNom());
        p.setPrenom(personne.getPrenom());
        p.setMarie(p.getMarie());
        p.setChomeur(personne.getChomeur());
        p.setGenre(personne.getGenre());
        p.setDate_de_naissance(personne.getDate_de_naissance());
        p.setAge(personne.getAge());
        p.setCompteList(personne.getCompteList());
        p.setEmploye(personne.getEmploye());
        p.setListeenfant(personne.getListeenfant());
        p.setMarriageFemme(personne.getMarriageFemme());
        p.setMarriageMari(personne.getMarriageMari());
        p.setSocieteList(personne.getSocieteList());
        personneRepository.save(p);
        return ResponseEntity.status(HttpStatus.OK).body(p);


    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @PutMapping(path="/{id}")
    ResponseEntity<Void> updatePersonne(@PathVariable int id ,
                                      @RequestBody Personne personne){



        Optional<Personne> app1 = personneRepository.findById(id);
        if (app1.isPresent()){
            Personne p = app1.get();
            p.setNom(personne.getNom());
            p.setPrenom(personne.getPrenom());
            p.setMarie(p.getMarie());
            p.setChomeur(personne.getChomeur());
            p.setGenre(personne.getGenre());
            p.setDate_de_naissance(personne.getDate_de_naissance());
            p.setAge(personne.getAge());
            p.setCompteList(personne.getCompteList());
            p.setEmploye(personne.getEmploye());
            p.setListeenfant(personne.getListeenfant());
            p.setMarriageFemme(personne.getMarriageFemme());
            p.setMarriageMari(personne.getMarriageMari());
            p.setSocieteList(personne.getSocieteList());
            personneRepository.save(p);
        }
        else {
            System.out.println("object not found");
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @DeleteMapping(path="/{id}")
    ResponseEntity<Void> deletePersonne(@PathVariable int id){


        personneRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
