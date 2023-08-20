package org.rina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.rina.enums.TypeFichier;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fichier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomFichier;
    @Enumerated(EnumType.STRING)
    private TypeFichier typeF;
    private Date date;
    private String fileURL;
    @ManyToOne
    private PersonneContact personneContact;

}
