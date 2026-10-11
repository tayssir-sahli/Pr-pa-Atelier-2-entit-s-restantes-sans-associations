package tn.esprit.tpfoyer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entity.Agence;

public interface IAgenceRepository extends JpaRepository<Agence, Long> {
}
