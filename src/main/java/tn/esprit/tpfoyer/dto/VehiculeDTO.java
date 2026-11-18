package tn.esprit.tpfoyer.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeDTO {

    private Long idVehicule;

    @NotBlank(message = "L'immatriculation est obligatoire")
    private String immatriculation;

    @NotBlank(message = "La marque est obligatoire")
    private String marque;

    @NotBlank(message = "Le modèle est obligatoire")
    private String modele;

    @NotBlank(message = "La catégorie est obligatoire")
    private String categorie;

    @NotNull(message = "Le tarif journalier est obligatoire")
    @Positive(message = "Le tarif doit être supérieur à zéro")
    private BigDecimal tarifJournalier;

    @NotBlank(message = "Le statut est obligatoire")
    private String statut;
}