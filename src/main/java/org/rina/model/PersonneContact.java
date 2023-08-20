package org.rina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.rina.enums.StatutM;
import org.rina.enums.TypePersonne;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonneContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate dateNaissance;
    private String tel1;//String(numberFormat)
    private String tel2;//String(numberFormat)
    private String adresse;
    @Enumerated(EnumType.STRING)
    private TypePersonne choix;
    @Enumerated(EnumType.STRING)
    private StatutM statutM;
    @OneToOne
    private User user;

}
