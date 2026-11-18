package tn.esprit.tpfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InheritInverseConfiguration;
import tn.esprit.tpfoyer.dto.ReservationDTO;
import tn.esprit.tpfoyer.entity.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    ReservationDTO toDTO(Reservation reservation);

    @InheritInverseConfiguration
    Reservation toEntity(ReservationDTO dto);
}