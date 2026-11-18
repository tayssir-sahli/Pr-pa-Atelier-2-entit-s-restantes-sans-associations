package tn.esprit.tpfoyer.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import tn.esprit.tpfoyer.entity.RoleEmploye;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDTO {

    private Long idEmploye;

    @NotBlank(message = "Le nom est obligatoire")
    @Size(min = 2, max = 50)
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    @Size(min = 2, max = 50)
    private String prenom;

    @NotNull(message = "Le rôle est obligatoire")
    private RoleEmploye role;
}