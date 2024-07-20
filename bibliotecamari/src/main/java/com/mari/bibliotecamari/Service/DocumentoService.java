package projeto.Mari.Biblioteca.service;

import projeto.Mari.Biblioteca.dto.ImprentaDTO;
import projeto.Mari.Biblioteca.entity.Documento;
import projeto.Mari.Biblioteca.mapper.DocumentoMapper;
import projeto.Mari.Biblioteca.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {
    @Autowired
    private DocumentoRepository repository;
    @Autowired
    private DocumentoMapper mapper;

    public List<ImprentaDTO> findAll(){
        List<Documento> documentos = repository.findAll();
        return mapper.paraDTO(documentos);
    }
    public ImprentaDTO findById(Long id) {
        Documento documento = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Modelo com id" + id + "Não foi encontrado"));
        return mapper.paraDTO(documento);

    }

    public Long save(ImprentaDTO imprentaDTO) {
        Documento documento = mapper.paraEntity(imprentaDTO);
        return repository.save(documento).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Modelo com id" + id + "Não foi encontrado");
        }
    }

    public Long update(ImprentaDTO imprentaDTO) {
        Documento documento = mapper.paraEntity(imprentaDTO);
        if (repository.existsById(documento.getId())) {
            return repository.save(documento).getId();
        } else {
            throw new RuntimeException("Modelo com id" + documento.getId() + "Não foi encontrado");
        }
    }
}
