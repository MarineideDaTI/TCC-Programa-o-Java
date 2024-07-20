package projeto.Mari.Biblioteca.mapper;

import projeto.Mari.Biblioteca.dto.AlunosDTO;
import projeto.Mari.Biblioteca.entity.Alunos;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlunosMapper {
    AlunosMapper INSTANCE = Mappers.getMapper(AlunosMapper.class);

    AlunosDTO toDTO(Alunos alunos);

    Alunos toEntity(AlunosDTO alunosDTO);

    List<AlunosDTO> toDTO(List<Alunos> alunos);

    List<Alunos> toEntity(List<AlunosDTO> alunosDTO);
}
