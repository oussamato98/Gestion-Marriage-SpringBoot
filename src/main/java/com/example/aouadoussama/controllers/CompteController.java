package com.example.aouadoussama.controllers;

import com.example.aouadoussama.entities.Compte;
import com.example.aouadoussama.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "compte")
public class CompteController {
    @Autowired
    CompteRepository compteRepository ;

    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")

    @GetMapping
    ResponseEntity<List<Compte>> getComptes(){

        List<Compte> compteList = compteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(compteList);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @PostMapping
    ResponseEntity<Compte> addCompte(@RequestBody Compte cpt){

        Compte c = new Compte();
        c.setSolde(cpt.getSolde());
        c.setPersonne(cpt.getPersonne());
        c.setPoste(cpt.getPoste());
        compteRepository.save(c);
        return ResponseEntity.status(HttpStatus.OK).body(c);


    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @PutMapping(path="/{id}")
    ResponseEntity<Void> updateCompte(@PathVariable int id ,
                                        @RequestBody Compte cpt){



        Optional<Compte> app1 = compteRepository.findById(id);
        if (app1.isPresent()){
            Compte app2 = app1.get();
            app2.setSolde(cpt.getSolde());
            app2.setPersonne(cpt.getPersonne());
            app2.setPoste(cpt.getPoste());
            compteRepository.save(app2);
        }
        else {
            System.out.println("object not found");
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @DeleteMapping(path="/{id}")
    ResponseEntity<Void> deleteCompte(@PathVariable int id){


        compteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}
