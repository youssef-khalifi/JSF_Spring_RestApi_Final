package com.dao.impl;

import com.dao.FiliereDao;
import com.entities.Filiere;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FiliereDaoImpl extends HibernateDaoSupport implements FiliereDao {

    @Autowired
    public void setUpSessionFactory(SessionFactory sessionFactory) {
        System.out.println("Setting up SessionFactory");
        this.setSessionFactory(sessionFactory);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Filiere filiere) {
        System.out.println("saveOrUpdate filiere");
        this.getHibernateTemplate().saveOrUpdate(filiere);
    }

    @Override
    @Transactional
    public void delete(Filiere filiere) {
        System.out.println("delete filiere ");
        this.getHibernateTemplate().delete(filiere);
    }

    @Override
    public Filiere getById(Integer id) {
        System.out.println("get filiere by id");
        return this.getHibernateTemplate().get(Filiere.class , id);
    }

    @Override
    public List<Filiere> getAll() {
        System.out.println("get all filiere");
        List<Filiere> filieres = (List<Filiere>) this.getHibernateTemplate().findByCriteria(
                DetachedCriteria.forClass(Filiere.class));
        return filieres;
    }
    @Override
    public Filiere getByCode(String code) {
        System.out.println("get filiere by code");
        return this.getHibernateTemplate().get(Filiere.class , code);
    }
}
