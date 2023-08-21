package org.rina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RapportQuotidien {

    @Data
    @NoArgsConstructor
    @Embeddable
    public static class Id implements Serializable {
        private static final long serialVersionUID = 1L;
        @Column(name = "FKRESIDENT")
        protected Long residentId;
        @Column(name = "FKETABLISSEMENT")
        protected Long etablissementId;

        public Id(Long residentId, Long etablissementId) {
            this.residentId = residentId;
            this.etablissementId = etablissementId;
        }
    }

    @EmbeddedId
    private Id id = new Id();


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

    @ManyToOne
    private Resident resident;

    @ManyToOne
    private Etablissement etablissement;

}
