package com.service;

import com.entities.Filiere;

import java.util.List;

public interface FiliereService {
    void saveOrUpdate(Filiere f);
    void delete(Filiere f);
    Filiere getById(int id);
    List<Filiere> getAll();
    Filiere getByCode(String code);
}
