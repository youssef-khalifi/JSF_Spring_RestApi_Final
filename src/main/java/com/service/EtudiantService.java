package com.service;

import com.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    void saveOrUpdate(Etudiant e);
    void delete(Etudiant e);
    Etudiant getById(int id);
    List<Etudiant> getAll();
}
