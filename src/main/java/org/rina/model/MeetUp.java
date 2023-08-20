package org.rina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.rina.enums.Etat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MeetUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeM;
    private String motifDemande;
    private Date date;
    @ManyToOne
    private Resident resident;
    @ManyToOne
    private PersonneContact personneContact;
    private int nbrParticipants;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    private String motifRefus;
    @ManyToOne
    private Etablissement etablissement;

}
