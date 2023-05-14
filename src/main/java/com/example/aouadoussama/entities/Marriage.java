package com.example.aouadoussama.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marriage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    Date date ;

    // Personne
    @OneToOne
    Personne personneMari ;
    @OneToOne
    Personne personneFemme;

}
