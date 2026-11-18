package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import tn.esprit.tpfoyer.dto.MaintenanceDTO;
import tn.esprit.tpfoyer.entity.Maintenance;

@Mapper(componentModel = "spring")
public interface MaintenanceMapper {

    MaintenanceDTO toDTO(Maintenance maintenance);

    @InheritInverseConfiguration
    Maintenance toEntity(MaintenanceDTO dto);
}