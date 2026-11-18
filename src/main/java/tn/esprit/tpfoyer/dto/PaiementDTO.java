package tn.esprit.tpfoyer.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import tn.esprit.tpfoyer.entity.ModePaiement;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaiementDTO {

    private Long idPaiement;

    @NotNull(message = "Le montant est obligatoire")
    @Positive(message = "Le montant doit être supérieur à zéro")
    private BigDecimal montant;

    @NotNull(message = "La date de paiement est obligatoire")
    @PastOrPresent(message = "La date de paiement ne peut pas être dans le futur")
    private LocalDate datePaiement;

    @NotNull(message = "Le mode de paiement est obligatoire")
    private ModePaiement modePaiement;
}