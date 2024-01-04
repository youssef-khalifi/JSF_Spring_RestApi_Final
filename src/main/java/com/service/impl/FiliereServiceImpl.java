package com.service.impl;

import com.dao.FiliereDao;
import com.entities.Filiere;
import com.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FiliereServiceImpl implements FiliereService {
    @Autowired
    private FiliereDao filiereDao;
    @Override
    @Transactional
    public void saveOrUpdate(Filiere f) {
        this.filiereDao.saveOrUpdate(f);
    }
    @Override
    @Transactional
    public void delete(Filiere f) {
        this.filiereDao.delete(f);
    }
    @Override
    public Filiere getById(int id) {
        return this.filiereDao.getById(id);
    }
    @Override
    public List<Filiere> getAll() {
        return this.filiereDao.getAll();
    }
    @Override
    public Filiere getByCode(String code) {
        return this.filiereDao.getByCode(code);
    }
}
