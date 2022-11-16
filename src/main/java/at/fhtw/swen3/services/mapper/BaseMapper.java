package at.fhtw.swen3.services.mapper;

public interface BaseMapper<EN, DTO> {
    DTO entityToDto(EN entity);

    EN dtoToEntity(DTO dto);
}
