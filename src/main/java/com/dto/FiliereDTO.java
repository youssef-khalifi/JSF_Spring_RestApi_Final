package com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FiliereDTO {
    private Integer id;
    private String code;
    private String libelle;
}
