package tn.esprit.tpfoyer.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipementDTO {

    private Long idEquipement;

    @NotBlank(message = "Le libellé est obligatoire")
    @Size(min = 2, max = 100)
    private String libelle;
}