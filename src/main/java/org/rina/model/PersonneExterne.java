package org.rina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.rina.enums.TypePersonne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonneExterne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    @Enumerated(EnumType.STRING)
    private TypePersonne choix;
}
