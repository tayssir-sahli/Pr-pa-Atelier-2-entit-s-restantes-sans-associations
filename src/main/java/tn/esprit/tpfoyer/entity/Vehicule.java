package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vehicule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @NotBlank(message = "L'immatriculation est obligatoire")
    @Size(max = 20, message = "L'immatriculation ne doit pas dépasser 20 caractères")
    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;

    @NotBlank(message = "La marque est obligatoire")
    @Size(max = 50, message = "La marque ne doit pas dépasser 50 caractères")
    @Column(nullable = false, length = 50)
    private String marque;

    @NotBlank(message = "Le modèle est obligatoire")
    @Size(max = 50, message = "Le modèle ne doit pas dépasser 50 caractères")
    @Column(nullable = false, length = 50)
    private String modele;

    @NotNull(message = "La catégorie est obligatoire")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategorieVehicule categorie;

    @NotNull(message = "Le tarif journalier est obligatoire")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le tarif journalier doit être supérieur à 0")
    @Digits(integer = 8, fraction = 2, message = "Tarif invalide (8 chiffres max, 2 décimales)")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;

    @NotNull(message = "Le statut est obligatoire")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agence agence;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "id_vehicule"),
            inverseJoinColumns = @JoinColumn(name = "id_equipement"))
    private Set<Equipement> equipements = new HashSet<>();

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    private List<Maintenance> maintenances = new ArrayList<>();
}