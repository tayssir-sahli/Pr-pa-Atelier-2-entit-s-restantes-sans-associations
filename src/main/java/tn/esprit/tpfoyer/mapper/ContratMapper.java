package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import tn.esprit.tpfoyer.dto.ContratDTO;
import tn.esprit.tpfoyer.entity.Contrat;

@Mapper(componentModel = "spring")
public interface ContratMapper {

    ContratDTO toDTO(Contrat contrat);

    @InheritInverseConfiguration
    Contrat toEntity(ContratDTO dto);
}