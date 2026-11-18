package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import tn.esprit.tpfoyer.dto.EquipementDTO;
import tn.esprit.tpfoyer.entity.Equipement;

@Mapper(componentModel = "spring")
public interface EquipementMapper {

    EquipementDTO toDTO(Equipement equipement);

    @InheritInverseConfiguration
    Equipement toEntity(EquipementDTO dto);
}