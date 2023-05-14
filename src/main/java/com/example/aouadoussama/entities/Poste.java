package com.example.aouadoussama.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    double salaire ;

    //Societe
    @OneToMany(mappedBy = "employeur",fetch = FetchType.EAGER)
    Set<Societe> societeList = new HashSet<>();

    // Compte
    @OneToOne
    Compte compte ;

    // Personne
    @OneToMany(mappedBy = "employe",fetch = FetchType.EAGER)
    List<Personne> personneList = new ArrayList<>();

    // Methodes
    public void payer(){

    }

}
