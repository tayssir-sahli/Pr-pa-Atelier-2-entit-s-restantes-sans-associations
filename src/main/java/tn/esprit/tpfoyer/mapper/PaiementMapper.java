package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import tn.esprit.tpfoyer.dto.PaiementDTO;
import tn.esprit.tpfoyer.entity.Paiement;

@Mapper(componentModel = "spring")
public interface PaiementMapper {

    PaiementDTO toDTO(Paiement paiement);

    @InheritInverseConfiguration
    Paiement toEntity(PaiementDTO dto);
}