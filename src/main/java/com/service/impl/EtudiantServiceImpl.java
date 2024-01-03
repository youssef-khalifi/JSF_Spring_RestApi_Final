package com.service.impl;

import com.dao.EtudiantDao;
import com.entities.Etudiant;
import com.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantDao etudiantDao;
    @Override
    @Transactional
    public void saveOrUpdate(Etudiant e) {
        this.etudiantDao.saveOrUpdate(e);
    }
    @Override
    @Transactional
    public void delete(Etudiant e) {
        this.etudiantDao.delete(e);
    }
    @Override
    public Etudiant getById(int id) {
        return this.etudiantDao.getById(id);
    }
    @Override
    public List<Etudiant> getAll() {
        return this.etudiantDao.getAll();
    }
}
