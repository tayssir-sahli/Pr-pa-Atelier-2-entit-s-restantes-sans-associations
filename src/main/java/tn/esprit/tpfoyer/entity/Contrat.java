package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @NotNull(message = "La date de signature est obligatoire")
    @PastOrPresent(message = "La date de signature ne peut pas être dans le futur")
    @Column(nullable = false)
    private LocalDate dateSignature;

    @NotNull(message = "Le montant total est obligatoire")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le montant total doit être supérieur à 0")
    @Digits(integer = 8, fraction = 2, message = "Montant invalide (8 chiffres max, 2 décimales)")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montantTotal;

    @NotNull(message = "Le champ valide est obligatoire")
    @Column(nullable = false)
    private Boolean valide;

    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Paiement> paiements = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Reservation reservation;
}