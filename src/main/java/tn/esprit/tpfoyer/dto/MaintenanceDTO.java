package tn.esprit.tpfoyer.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceDTO {

    private Long idMaintenance;

    @NotNull(message = "La date de début est obligatoire")
    @PastOrPresent(message = "La date de début ne peut pas être dans le futur")
    private LocalDate dateDebut;

    private LocalDate dateFin;

    @NotBlank(message = "La description est obligatoire")
    @Size(min = 5, max = 500)
    private String description;

    @AssertTrue(message = "La date de fin doit être après la date de début")
    public boolean isDatesValid() {
        return dateDebut == null || dateFin == null
                || !dateFin.isBefore(dateDebut);
    }
}