package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;
import tn.esprit.tpfoyer.dto.VehiculeDTO;
import tn.esprit.tpfoyer.entity.Vehicule;

@Mapper(componentModel = "spring")
public interface VehiculeMapper {

    @Mapping(source = "agence.idAgence", target = "idAgence")
    VehiculeDTO toDTO(Vehicule vehicule);

    @Mapping(target = "agence", ignore = true)
    @Mapping(target = "equipements", ignore = true)
    @Mapping(target = "maintenances", ignore = true)
    @InheritInverseConfiguration
    Vehicule toEntity(VehiculeDTO dto);
}