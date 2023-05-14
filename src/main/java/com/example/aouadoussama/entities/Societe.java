package com.example.aouadoussama.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    //Poste
    @ManyToOne
    Poste employeur ;

    //Personne
    @ManyToOne
    Personne personne ;


    // Methodes
    public double liquidites(){
        double l =1 ;
        return l ;
    }
}
