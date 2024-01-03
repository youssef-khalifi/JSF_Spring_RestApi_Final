package com.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class FiliereDTO {

    private Integer id;
    private String code;
    private String Libelle;
    private Collection<EtudiantDTO> etudiantDTO;
}
