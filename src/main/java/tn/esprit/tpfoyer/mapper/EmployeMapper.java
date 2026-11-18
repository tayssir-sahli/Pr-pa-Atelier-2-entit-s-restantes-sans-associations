package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import tn.esprit.tpfoyer.dto.EmployeDTO;
import tn.esprit.tpfoyer.entity.Employe;

@Mapper(componentModel = "spring")
public interface EmployeMapper {

    EmployeDTO toDTO(Employe employe);

    @InheritInverseConfiguration
    Employe toEntity(EmployeDTO dto);
}
