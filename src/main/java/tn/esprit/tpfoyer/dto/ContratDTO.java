package tn.esprit.tpfoyer.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratDTO {

    private Long idContrat;

    @NotNull(message = "La date de signature est obligatoire")
    @PastOrPresent(message = "La date de signature ne peut pas être dans le futur")
    private LocalDate dateSignature;

    @NotNull(message = "Le montant total est obligatoire")
    @Positive(message = "Le montant doit être supérieur à zéro")
    private BigDecimal montantTotal;

    @NotNull(message = "La validation du contrat est obligatoire")
    private Boolean valide;
}