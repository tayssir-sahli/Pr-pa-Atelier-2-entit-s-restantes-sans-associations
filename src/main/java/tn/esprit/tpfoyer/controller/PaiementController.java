
package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Paiement;
import tn.esprit.tpfoyer.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
@Tag(name = "Paiements", description = "Consultation des paiements")
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping("/{id}")
    @Operation(summary = "Consulter un paiement")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Paiement trouvé"),
            @ApiResponse(responseCode = "404", description = "Paiement introuvable")
    })
    public Paiement findById(
            @Parameter(description = "Identifiant du paiement")
            @PathVariable Long id) {
        return paiementService.findById(id);
    }

    @GetMapping
    @Operation(summary = "Lister les paiements")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Liste des paiements récupérée")
    })
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }
}
