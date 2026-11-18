package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import tn.esprit.tpfoyer.dto.AgenceDTO;
import tn.esprit.tpfoyer.entity.Agence;

@Mapper(componentModel = "spring")
public interface AgenceMapper {

    AgenceDTO toDTO(Agence agence);

    @InheritInverseConfiguration
    Agence toEntity(AgenceDTO dto);
}