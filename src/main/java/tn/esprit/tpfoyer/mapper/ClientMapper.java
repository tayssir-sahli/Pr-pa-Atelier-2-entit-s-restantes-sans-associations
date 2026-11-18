package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import tn.esprit.tpfoyer.dto.ClientDTO;
import tn.esprit.tpfoyer.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDTO(Client client);

    @InheritInverseConfiguration
    Client toEntity(ClientDTO dto);
}
