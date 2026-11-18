package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères")
    @Column(nullable = false, length = 50)
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    @Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères")
    @Column(nullable = false, length = 50)
    private String prenom;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format d'email invalide")
    @Size(max = 100, message = "L'email ne doit pas dépasser 100 caractères")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Pattern(regexp = "^$|^\\+?[0-9 ]{8,20}$", message = "Numéro de téléphone invalide")
    @Size(max = 20, message = "Le téléphone ne doit pas dépasser 20 caractères")
    @Column(length = 20)
    private String telephone;

    @NotBlank(message = "Le numéro de permis est obligatoire")
    @Size(max = 30, message = "Le numéro de permis ne doit pas dépasser 30 caractères")
    @Column(nullable = false, unique = true, length = 30)
    private String numPermis;

    @PastOrPresent(message = "La date d'inscription ne peut pas être dans le futur")
    private LocalDate dateInscription;

    @OneToMany(mappedBy = "client",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();
}