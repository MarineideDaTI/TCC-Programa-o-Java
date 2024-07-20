package projeto.Mari.Biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.Mari.Biblioteca.dto.AlunosDTO;
import projeto.Mari.Biblioteca.entity.Alunos;
import projeto.Mari.Biblioteca.mapper.AlunosMapper;
import projeto.Mari.Biblioteca.repository.AlunosRepository;

import java.util.List;

@Service
public class UsuarioExternoService {
    @Autowired
    private AlunosRepository repository;
    @Autowired
    private AlunosMapper mapper;

    public List<AlunosDTO> findAll(){
        List<Alunos> alunos = repository.findAll();
        return mapper.paraDTO(alunos);
    }
    public AlunosDTO findById(Long id) {
        Alunos alunos = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Carro com id" + id + "Não foi encontrado"));
        return mapper.paraDTO(alunos);

    }

    public Long save(AlunosDTO alunosDTO) {
        Alunos alunos = mapper.paraEntity(alunosDTO);
        return repository.save(alunos).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Carro com id" + id + "Não foi encontrado");
        }
    }
    public Long update (AlunosDTO alunosDTO) {
        Alunos alunos = mapper.paraEntity(alunosDTO);
        if (repository.existsById(alunos.getId())) {
            return repository.save(alunos).getId();
        } else {
            throw new RuntimeException("Carro com id" + alunos.getId() + "Não foi encontrado");
        }
    }

}
