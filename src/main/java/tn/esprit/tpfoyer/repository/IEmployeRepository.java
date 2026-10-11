
package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Employe;

public interface IEmployeRepository extends JpaRepository<Employe, Long> {
}
