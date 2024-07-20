package com.mari.bibliotecamari.Mapper;

import com.mari.bibliotecamari.Entity.AlunosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.mari.bibliotecamari.DTO.AlunosDTO;
import java.util.List;

@Mapper(componentModel = "spring")
public interface AlunosMapper {
    AlunosMapper INSTANCE = Mappers.getMapper(AlunosMapper.class);

    AlunosDTO toDTO(Alunos alunos);

    Alunos toEntity(AlunosDTO alunosDTO);

    List<AlunosDTO> toDTO(List<Alunos> alunos);

    List<Alunos> toEntity(List<AlunosDTO> alunosDTO);
}
