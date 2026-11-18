package tn.esprit.tpfoyer.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import tn.esprit.tpfoyer.entity.StatutReservation;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Long idReservation;

    @NotNull(message = "La date de début est obligatoire")
    @FutureOrPresent(message = "La date de début doit être aujourd'hui ou dans le futur")
    private LocalDate dateDebut;

    @NotNull(message = "La date de fin est obligatoire")
    @Future(message = "La date de fin doit être dans le futur")
    private LocalDate dateFin;

    @NotNull(message = "Le statut est obligatoire")
    private StatutReservation statut;

    @AssertTrue(message = "La date de fin doit être après la date de début")
    public boolean isDatesValid() {
        return dateDebut == null || dateFin == null
                || dateFin.isAfter(dateDebut);
    }
}