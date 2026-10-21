
package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Contrat;
import tn.esprit.tpfoyer.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@RequiredArgsConstructor
@Tag(name = "Contrats", description = "Gestion des contrats de location")
public class ContratController {

    private final IContratService contratService;

    @PostMapping
    @Operation(summary = "Créer un contrat",
            description = "Ajouter un nouveau contrat de location")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrat créé"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    public Contrat create(@RequestBody Contrat contrat) {
        return contratService.create(contrat);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un contrat",
            description = "Rechercher un contrat par son identifiant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrat trouvé"),
            @ApiResponse(responseCode = "404", description = "Contrat introuvable")
    })
    public Contrat findById(
            @Parameter(description = "Identifiant du contrat")
            @PathVariable Long id) {
        return contratService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Lister les contrats",
            description = "Récupérer tous les contrats")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Liste des contrats récupérée")
    })
    public List<Contrat> findAll() {
        return contratService.findAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un contrat",
            description = "Modifier un contrat existant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrat modifié"),
            @ApiResponse(responseCode = "400", description = "Données invalides"),
            @ApiResponse(responseCode = "404", description = "Contrat introuvable")
    })
    public Contrat update(
            @Parameter(description = "Identifiant du contrat à modifier")
            @PathVariable Long id,
            @RequestBody Contrat contrat) {
        return contratService.update(id, contrat);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un contrat",
            description = "Supprimer un contrat existant")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contrat supprimé"),
            @ApiResponse(responseCode = "404", description = "Contrat introuvable")
    })
    public void delete(
            @Parameter(description = "Identifiant du contrat à supprimer")
            @PathVariable Long id) {
        contratService.deleteById(id);
    }
}
