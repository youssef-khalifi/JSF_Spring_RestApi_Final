package com.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EtudiantDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private String cne;
    private String filiere;
}
