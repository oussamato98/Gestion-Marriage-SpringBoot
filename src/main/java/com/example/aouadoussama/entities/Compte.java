package com.example.aouadoussama.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    double solde ;

    //Personne
    @ManyToOne
    Personne personne ;

    //Poste
    @OneToOne
    Poste poste ;

    // Methodes
    public double getSolde(){
        double c=1 ;
        return c;
    }

    public void crediter(double somme){

    }

    public void debiter(double somme){

    }


}
