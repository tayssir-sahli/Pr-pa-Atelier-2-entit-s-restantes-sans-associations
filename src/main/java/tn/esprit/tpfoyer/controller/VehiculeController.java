
package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.dto.VehiculeDTO;
import tn.esprit.tpfoyer.entity.Vehicule;
import tn.esprit.tpfoyer.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
@Tag(name = "Véhicules", description = "Gestion des véhicules")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Créer un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Véhicule créé"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.create(vehicule);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    public Vehicule findById(
            @Parameter(description = "Identifiant du véhicule")
            @PathVariable Long id) {
        return vehiculeService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Lister les véhicules")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée")
    public List<Vehicule> findAll() {
        return vehiculeService.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule modifié"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    public Vehicule update(
            @Parameter(description = "Identifiant du véhicule")
            @PathVariable Long id,
            @RequestBody Vehicule vehicule) {
        return vehiculeService.update(id, vehicule);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Supprimer un véhicule")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Véhicule supprimé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
    })
    public void delete(@PathVariable Long id) {
        vehiculeService.deleteById(id);
    }


    @Operation(
            summary = "Affecter un véhicule à une agence",
            description = "Permet d'affecter un véhicule existant à une agence existante."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Véhicule affecté avec succès à l'agence"),
            @ApiResponse(responseCode = "400", description = "Identifiant invalide"),
            @ApiResponse(responseCode = "404", description = "Agence ou véhicule introuvable"),
            @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
    })
    @PutMapping("/{idAgence}/affecterVehicule/{idVehicule}")
    public ResponseEntity<VehiculeDTO> affecterVehicule(
            @PathVariable @Positive(message = "L'id de l'agence doit être positif") Long idAgence,
            @PathVariable @Positive(message = "L'id du véhicule doit être positif") Long idVehicule) {

        return ResponseEntity.ok(vehiculeService.affecterVehiculeAgence(idVehicule, idAgence));
    }
}
