
package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> {
}
