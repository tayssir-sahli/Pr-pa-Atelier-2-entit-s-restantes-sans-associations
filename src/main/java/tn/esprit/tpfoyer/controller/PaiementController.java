
package tn.esprit.tpfoyer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Paiement;
import tn.esprit.tpfoyer.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping("/{id}")
    public Paiement findById(@PathVariable Long id) {
        return paiementService.findById(id);
    }

    @GetMapping
    public List<Paiement> findAll() {
        return paiementService.findAll();
    }
}
