package com.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filiere {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "CODE", nullable = true, length = 255)
    private String code;
    @Basic
    @Column(name = "LIBELLE", nullable = false, length = 255)
    private String libelle;
    @OneToMany(mappedBy = "filiere", fetch = FetchType.EAGER)
    private Collection<Etudiant> etudiantsById;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filiere filiere = (Filiere) o;

        if (id != filiere.id) return false;
        if (code != null ? !code.equals(filiere.code) : filiere.code != null) return false;
        if (libelle != null ? !libelle.equals(filiere.libelle) : filiere.libelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Filiere{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}