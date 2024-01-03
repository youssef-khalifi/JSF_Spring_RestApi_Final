package com.dao;

import com.entities.Filiere;

public interface FiliereDao extends IDAO<Filiere>{
    Filiere getByCode(String code);
}
