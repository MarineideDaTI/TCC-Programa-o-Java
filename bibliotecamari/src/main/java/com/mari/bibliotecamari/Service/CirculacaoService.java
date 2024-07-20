package projeto.Mari.Biblioteca.service;

import projeto.Mari.Biblioteca.dto.DocumentoDTO;
import projeto.Mari.Biblioteca.mapper.CirculacaoMapper;
import projeto.Mari.Biblioteca.repository.CirculacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CirculacaoService {
    @Autowired
    private CirculacaoRepository repository;
    @Autowired
    private CirculacaoMapper mapper;

    public List<DocumentoDTO> findAll() {
        List<projeto.Mari.Biblioteca.entity.Circulacao> circulacaos = repository.findAll();
        return mapper.paraDTO(circulacaos);
    }

    public DocumentoDTO findById(Long id) {
        projeto.Mari.Biblioteca.entity.Circulacao circulacao = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Cliente com id" + id + "Não foi encontrado"));
        return mapper.paraDTO(circulacao);

    }

    public Long save(DocumentoDTO documentoDTO) {
        projeto.Mari.Biblioteca.entity.Circulacao circulacao = mapper.paraEntity(documentoDTO);
        return repository.save(circulacao).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente com id" + id + "Não foi encontrado");
        }
    }
    public Long update (DocumentoDTO documentoDTO) {
        projeto.Mari.Biblioteca.entity.Circulacao circulacao = mapper.paraEntity(documentoDTO);
        if (repository.existsById(circulacao.getId())) {
           return repository.save(circulacao).getId();
        } else {
            throw new RuntimeException("Cliente com id" + circulacao.getId() + "Não foi encontrado");
        }
    }
}
