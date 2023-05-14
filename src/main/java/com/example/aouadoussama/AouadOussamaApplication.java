package com.example.aouadoussama;

import com.example.aouadoussama.entities.*;
import com.example.aouadoussama.repositories.CompteRepository;
import com.example.aouadoussama.repositories.MarriageRepository;
import com.example.aouadoussama.repositories.PersonneRepository;
import com.example.aouadoussama.repositories.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class AouadOussamaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AouadOussamaApplication.class, args);
    }

    @Autowired
    PersonneRepository personneRepository ;
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    PosteRepository posteRepository;
    @Autowired
    MarriageRepository marriageRepository;
    @Bean
    CommandLineRunner start() {
        return args -> {

            Personne p = new Personne();
            p.setNom("aouad");
            p.setPrenom("oussama");
            p.setMarie(false);
            p.setChomeur(false);
            p.setGenre(Genre.homme);
            p.setDate_de_naissance(new Date());
            p.setAge(25);
            personneRepository.save(p);

            Compte c = new Compte();
            c.setSolde(20000);
            c.setPersonne(p);
            compteRepository.save(c);


            Poste poste = new Poste();
            poste.setCompte(c);
            poste.setSalaire(999999);
            posteRepository.save(poste);

            Marriage m = new Marriage();
            m.setDate(new Date());
            marriageRepository.save(m);



        };
    }
}
