package projeto.Mari.Biblioteca.service;

import projeto.Mari.Biblioteca.dto.ObrasDTO;
import projeto.Mari.Biblioteca.entity.Curso;
import projeto.Mari.Biblioteca.mapper.CursoMapper;
import projeto.Mari.Biblioteca.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;
    @Autowired
    private CursoMapper mapper;

    public List<ObrasDTO> findAll(){
        List<Curso> cursos = repository.findAll();
        return mapper.paraDTO(cursos);
    }
    public ObrasDTO findById(Long id) {
        Curso curso = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Fabricante com id" + id + "Não foi encontrado"));
        return mapper.paraDTO(curso);

    }

    public Long save(ObrasDTO obrasDTO) {
        Curso curso = mapper.paraEntity(obrasDTO);
        return repository.save(curso).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Fabricante com id" + id + "Não foi encontrado");
        }
    }

    public Long update(ObrasDTO obrasDTO) {
        Curso curso = mapper.paraEntity(obrasDTO);
        if (repository.existsById(curso.getId())) {
            return repository.save(curso).getId();
        } else {
            throw new RuntimeException("Fabricante com id" + curso.getId() + "Não foi encontrado");
        }
    }
}
