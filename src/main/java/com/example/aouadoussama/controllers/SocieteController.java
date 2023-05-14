package com.example.aouadoussama.controllers;

import com.example.aouadoussama.entities.Societe;
import com.example.aouadoussama.repositories.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "societe")
public class SocieteController {
    @Autowired
    SocieteRepository societeRepository;
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")

    @GetMapping
    ResponseEntity<List<Societe>> getSocietes(){

        List<Societe> societeList = societeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(societeList);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @PostMapping
    ResponseEntity<Societe> addSociete(@RequestBody Societe s  ){

        Societe soc = new Societe();
        soc.setEmployeur(s.getEmployeur());
        soc.setPersonne(s.getPersonne());
        societeRepository.save(soc);
        return ResponseEntity.status(HttpStatus.OK).body(soc);


    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @PutMapping(path="/{id}")
    ResponseEntity<Void> updatePoste(@PathVariable int id ,
                                     @RequestBody Societe s){



        Optional<Societe> app1 = societeRepository.findById(id);
        if (app1.isPresent()){
            Societe app2 = app1.get();
            app2.setPersonne(s.getPersonne());
            app2.setEmployeur(s.getEmployeur());


            societeRepository.save(app2);
        }
        else {
            System.out.println("object not found");
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @DeleteMapping(path="/{id}")
    ResponseEntity<Void> deletePoste(@PathVariable int id){


        societeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
