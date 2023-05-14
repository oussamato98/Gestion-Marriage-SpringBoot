package com.example.aouadoussama.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    String nom ;
    String prenom ;
    Boolean marie ;
    Boolean chomeur ;

    @Enumerated(EnumType.STRING)
    Genre genre;
    Date date_de_naissance;
    int age ;

    // Societe
    @OneToMany(mappedBy = "personne",fetch = FetchType.EAGER)
    List<Societe> societeList = new ArrayList<>();

    //Poste
    @ManyToOne
    Poste employe;

    // Marriage
    @OneToOne
    Marriage marriageMari ;
    @OneToOne
    Marriage marriageFemme;

    //PersonneEnfant

    @OneToMany
    List<Personne> listeenfant = new ArrayList<>();

    //Compte
    @OneToMany(mappedBy = "personne",fetch = FetchType.EAGER)
    List<Compte> compteList = new ArrayList<>();

    // Methodes
    public double revenue(){
        double r =1 ;
        return r ;
    }
}
