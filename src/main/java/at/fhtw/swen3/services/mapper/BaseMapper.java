package at.fhtw.swen3.services.mapper;

public interface BaseMapper<EN, DTO> {
    DTO entityToDto(EN author);

    EN dtoToEntity(DTO authorDto);
}
