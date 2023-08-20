package org.rina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RapportQuotidien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Etablissement etablissement;
    @ManyToOne
    private Resident resident;
    private int numeroR;
    private String freqCardiaque;
    private String freqRespiratoire;
    private String presArterielle;
    private String temperature;
    private String satOxygene;
    private String selle;
    private String urine;
    private String sommeil;
    private String commentaire;

}
