package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 100, message = "Le nom ne doit pas dépasser 100 caractères")
    @Column(nullable = false, length = 100)
    private String nom;

    @NotBlank(message = "La ville est obligatoire")
    @Size(max = 50, message = "La ville ne doit pas dépasser 50 caractères")
    @Column(nullable = false, length = 50)
    private String ville;

    @NotBlank(message = "L'adresse est obligatoire")
    @Size(max = 150, message = "L'adresse ne doit pas dépasser 150 caractères")
    @Column(nullable = false, length = 150)
    private String adresse;

    @Pattern(regexp = "^$|^\\+?[0-9 ]{8,20}$", message = "Numéro de téléphone invalide")
    @Size(max = 20, message = "Le téléphone ne doit pas dépasser 20 caractères")
    @Column(length = 20)
    private String telephone;

    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<Vehicule> vehicules = new ArrayList<>();

    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    private List<Employe> employes = new ArrayList<>();
}