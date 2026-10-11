
package tn.esprit.tpfoyer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final IReservationService reservationService;

    @PostMapping
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }

    @GetMapping("/{id}")
    public Reservation findById(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable Long id,
                              @RequestBody Reservation reservation) {
        return reservationService.update(id, reservation);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservationService.deleteById(id);
    }
}
