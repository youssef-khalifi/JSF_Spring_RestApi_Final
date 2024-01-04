package com.beans;

import com.entities.Filiere;
import com.service.FiliereService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Getter @Setter
@ManagedBean
@Component
@Scope("session")
public class FiliereBean {
    @Autowired
    private FiliereService filiereService;
    private Filiere filiere;
    private boolean Modify;
    public FiliereBean() {
        this.setFiliere(new Filiere());
        this.setModify(false);
    }
    public String getLabel(){
        if(!Modify) return "Save";
        return "Edit";
    }
    @Transactional
    public void save(){
        this.filiereService.saveOrUpdate(this.filiere);
        this.setFiliere(new Filiere());
        this.setModify(false);
    }
    public void modify(Filiere f){
        this.setModify(true);
        this.setFiliere(f);
    }
    @Transactional
    public void delete(Filiere f){
        this.filiereService.delete(f);
        this.setFiliere(new Filiere());
    }
    public List<Filiere> getFilieres(){
        return this.filiereService.getAll();
    }
}
