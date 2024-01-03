package com.beans;

import com.entities.Etudiant;
import com.entities.Filiere;
import com.service.EtudiantService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Getter
@Setter
@ManagedBean
@Component
@Scope("session")
public class EtudiantBean {

    @Autowired
    private EtudiantService etudiantService;
    private Etudiant etudiant;
    private Filiere filiere;
    private boolean Modify;



    public EtudiantBean() {
        this.setFiliere(new Filiere());
        this.setModify(false);
    }

    public String getLabel(){
        if(!Modify) return "Save";
        return "Edit";
    }
    public List<Etudiant> getEtudiants(){
        return this.etudiantService.getAll();
    }
    @Transactional
    public void save(){
        this.etudiant.setFiliere(this.filiere);
        this.etudiantService.saveOrUpdate(this.etudiant);
        this.setEtudiant(new Etudiant());
        this.setFiliere(new Filiere());
        this.setModify(false);
    }
    public void modify(Etudiant e){
        this.setEtudiant(e);
        this.setModify(true);
    }
    @Transactional
    public void delete(Etudiant e){
        this.etudiantService.delete(e);
        this.setEtudiant(new Etudiant());
    }
}
