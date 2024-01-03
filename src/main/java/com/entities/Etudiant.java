package com.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "NOM", nullable = false, length = 255)
    private String nom;
    @Basic
    @Column(name = "PRENOM", nullable = false, length = 255)
    private String prenom;
    @Basic
    @Column(name = "CNE", nullable = false, length = 255)
    private String cne;
    @ManyToOne
    @JoinColumn(name = "FILIERE", referencedColumnName = "ID")
    private Filiere filiere;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etudiant etudiant = (Etudiant) o;

        if (id != etudiant.id) return false;
        if (nom != null ? !nom.equals(etudiant.nom) : etudiant.nom != null) return false;
        if (prenom != null ? !prenom.equals(etudiant.prenom) : etudiant.prenom != null) return false;
        if (cne != null ? !cne.equals(etudiant.cne) : etudiant.cne != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (cne != null ? cne.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cne='" + cne + '\'' +
                '}';
    }
}