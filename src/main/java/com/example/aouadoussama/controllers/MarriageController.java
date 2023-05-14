package com.example.aouadoussama.controllers;

import com.example.aouadoussama.entities.Marriage;
import com.example.aouadoussama.repositories.MarriageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "marriage")
public class MarriageController {

    @Autowired
    MarriageRepository marriageRepository;
    @PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")

    @GetMapping
    ResponseEntity<List<Marriage>> getMarriages(){

        List<Marriage> marriageList = marriageRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(marriageList);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @PostMapping
    ResponseEntity<Marriage> addMarriage(@RequestBody Marriage marriage){

        Marriage m = new Marriage();
        m.setDate(marriage.getDate());
        m.setPersonneFemme(marriage.getPersonneFemme());
        m.setPersonneMari(marriage.getPersonneMari());
        marriageRepository.save(m);
        return ResponseEntity.status(HttpStatus.OK).body(m);

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @PutMapping(path="/{id}")
    ResponseEntity<Void> updateMarriage(@PathVariable int id ,
                                      @RequestBody Marriage m){



        Optional<Marriage> app1 = marriageRepository.findById(id);
        if (app1.isPresent()){
            Marriage app2 = app1.get();
            app2.setDate(m.getDate());
            app2.setPersonneMari(m.getPersonneMari());
            app2.setPersonneFemme(m.getPersonneFemme());

            marriageRepository.save(app2);
        }
        else {
            System.out.println("object not found");
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @DeleteMapping(path="/{id}")
    ResponseEntity<Void> deleteMarriage(@PathVariable int id){


        marriageRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}
