package com.example.aouadoussama.controllers;

import com.example.aouadoussama.entities.Poste;
import com.example.aouadoussama.repositories.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "poste")
public class PosteController {
    @Autowired
    PosteRepository posteRepository;
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")

    @GetMapping
    ResponseEntity<List<Poste>> getPostes(){

        List<Poste> posteList = posteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(posteList);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @PostMapping
    ResponseEntity<Poste> addPoste(@RequestBody Poste p ){

        Poste poste = new Poste();
        poste.setSalaire(p.getSalaire());
        poste.setCompte(p.getCompte());
        poste.setPersonneList(p.getPersonneList());
        poste.setSocieteList(p.getSocieteList());
        posteRepository.save(poste);
        return ResponseEntity.status(HttpStatus.OK).body(poste);


    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @PutMapping(path="/{id}")
    ResponseEntity<Void> updatePoste(@PathVariable int id ,
                                      @RequestBody Poste poste){



        Optional<Poste> app1 = posteRepository.findById(id);
        if (app1.isPresent()){
            Poste app2 = app1.get();
            app2.setSalaire(poste.getSalaire());
            app2.setCompte(poste.getCompte());
            app2.setPersonneList(poste.getPersonneList());
            app2.setSocieteList(poste.getSocieteList());

            posteRepository.save(app2);
        }
        else {
            System.out.println("object not found");
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @DeleteMapping(path="/{id}")
    ResponseEntity<Void> deletePoste(@PathVariable int id){


        posteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
