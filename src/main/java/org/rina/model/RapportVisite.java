package org.rina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RapportVisite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateVisite;
    private String commentaire;
    @ManyToOne
    private Resident resident;
    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private PersonneExterne personneExterne;
}
