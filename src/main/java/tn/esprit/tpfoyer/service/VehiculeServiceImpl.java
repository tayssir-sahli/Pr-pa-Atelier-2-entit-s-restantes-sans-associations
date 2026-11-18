package tn.esprit.tpfoyer.service;

import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import tn.esprit.tpfoyer.dto.VehiculeDTO;
import tn.esprit.tpfoyer.entity.Agence;
import tn.esprit.tpfoyer.entity.Vehicule;
import tn.esprit.tpfoyer.exception.ResourceNotFoundException;
import tn.esprit.tpfoyer.mapper.VehiculeMapper;
import tn.esprit.tpfoyer.repository.IAgenceRepository;
import tn.esprit.tpfoyer.repository.IVehiculeRepository;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;
    private final IAgenceRepository agenceRepository;
    private final VehiculeMapper vehiculeMapper;

    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicule", id));
    }

    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule update(Long id, Vehicule vehicule) {
        Vehicule existant = findById(id);

        BeanUtils.copyProperties(
                vehicule, existant, "id"
        );

        return vehiculeRepository.save(existant);
    }

    @Override
    public void deleteById(Long id) {
        Vehicule vehicule = findById(id);
        vehiculeRepository.delete(vehicule);
    }

    @Override
    @Transactional
    public VehiculeDTO affecterVehiculeAgence(Long idVehicule, Long idAgence) {

        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new ResourceNotFoundException("Agence", idAgence));

        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicule", idVehicule));

        vehicule.setAgence(agence);
        return vehiculeMapper.toDTO(vehiculeRepository.save(vehicule));
    }
}