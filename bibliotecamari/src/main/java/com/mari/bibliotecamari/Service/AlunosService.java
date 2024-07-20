package projeto.Mari.Biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto.Mari.Biblioteca.dto.AlunosDTO;
import projeto.Mari.Biblioteca.entity.Alunos;
import projeto.Mari.Biblioteca.mapper.AlunosMapper;
import projeto.Mari.Biblioteca.repository.AlunosRepository;

import java.util.List;

@Service
public class AlunosService {

    @Autowired
    private AlunosMapper mapper;

    @Autowired
    private AlunosRepository repository;

    public List<Alunos> findAll() {
        return repository.findAll();
    }

    public Long save(AlunosDTO alunosDTO) {
        Alunos alunos = mapper.toEntity(alunosDTO);
        return repository.save(alunos).getCodUsuario();
    }

    public void update(AlunosDTO alunosDTO) {
        Alunos alunos = mapper.toEntity(alunosDTO);
        if (repository.existsById(alunos.getCodUsuario())) {
            repository.save(alunos);
        } else {
            throw new RuntimeException("Aluno com ID " + alunos.getCodUsuario() + " não foi encontrado.");
        }
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Aluno com ID " + id + " não foi encontrado.");
        }
    }
}