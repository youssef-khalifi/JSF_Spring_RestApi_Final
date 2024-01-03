package com.dao.impl;

import com.dao.EtudiantDao;
import com.entities.Etudiant;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EtudiantFiliereImpl extends HibernateDaoSupport implements EtudiantDao {

    @Autowired
    public void setUpSessionFactory(SessionFactory sessionFactory) {
        System.out.println("Setting up SessionFactory");
        this.setSessionFactory(sessionFactory);
    }
    @Override
    @Transactional
    public void saveOrUpdate(Etudiant etudiant) {
        System.out.println("saveOrUpdate etudiant");
        this.getHibernateTemplate().saveOrUpdate(etudiant);
    }

    @Override
    @Transactional
    public void delete(Etudiant etudiant) {
        System.out.println("delete filiere");
        this.getHibernateTemplate().delete(etudiant);
    }

    @Override
    public Etudiant getById(int id) {
        System.out.println("get etudiant by id");
        return this.getHibernateTemplate().get(Etudiant.class , id);
    }

    @Override
    public List<Etudiant> getAll() {
        System.out.println("get all etudiant");
        return (List<Etudiant>) this.getHibernateTemplate().findByCriteria(
            DetachedCriteria.forClass(Etudiant.class)
        );
    }
}
