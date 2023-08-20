package org.rina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateDeNaissance;
    private String email;
    private String tel;
    private String adresse;
    private String status;
    private Date dateEntree;
    private String motifEntree;
    private Date dateSortie;
    private String motifSortie;
    private String antMedical;
    private String antChirugical;
    private int nbEnfant;
    private String chambre;
    private String etatSante;
    @OneToOne
    private User user;
    @ManyToMany
    private List<PersonneContact> personneContactList;
    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private MedecinTraitant medecinTraitant;
    private boolean actif;

}
