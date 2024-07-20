
package projeto.Mari.Biblioteca.service;
import projeto.Mari.Biblioteca.dto.UsuarioExternoDTO;
import projeto.Mari.Biblioteca.entity.Imprenta;
import projeto.Mari.Biblioteca.mapper.ImprentaMapper;
import projeto.Mari.Biblioteca.repository.ImprentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImprentaService {
    @Autowired
    private ImprentaRepository repository;
    @Autowired
    private ImprentaMapper mapper;

    public List<UsuarioExternoDTO> findAll(){
        List<Imprenta> imprentas = repository.findAll();
        return mapper.paraDTO(imprentas);
    }
    public UsuarioExternoDTO findById(Long id) {
        Imprenta imprenta = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Seguradora com id" + id + "Não foi encontrada"));
        return mapper.paraDTO(imprenta);

    }

    public Long save(UsuarioExternoDTO usuarioExternoDTO) {
        Imprenta imprenta = mapper.paraEntity(usuarioExternoDTO);
        return repository.save(imprenta).getId();
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Seguradora com id" + id + "Não foi encontrada");
        }
    }

    public Long update(UsuarioExternoDTO usuarioExternoDTO) {
        Imprenta imprenta = mapper.paraEntity(usuarioExternoDTO);
        if (repository.existsById(imprenta.getId())) {
            return repository.save(imprenta).getId();
        } else {
            throw new RuntimeException("Seguradora com id" + imprenta.getId() + "Não foi encontrada");
        }
    }
}
