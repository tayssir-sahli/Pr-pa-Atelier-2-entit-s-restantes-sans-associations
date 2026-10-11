package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Agence;

import java.util.List;

public interface IAgenceService {
    Agence create(Agence agence);
    Agence findById(Long id);
    List<Agence> findAll();
    Agence update(Long id, Agence agence);
    void deleteById(Long id);
}
