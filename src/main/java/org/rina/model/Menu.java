package org.rina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int semaine;
    @ElementCollection
    private List<String> lundi;
    @ElementCollection
    private List<String> mardi;
    @ElementCollection
    private List<String> mercredi;
    @ElementCollection
    private List<String> jeudi;
    @ElementCollection
    private List<String> vendredi;
    @ElementCollection
    private List<String> samedi;
    @ElementCollection
    private List<String> dimanche;
    @ManyToOne
    private Etablissement etablissement;
}
