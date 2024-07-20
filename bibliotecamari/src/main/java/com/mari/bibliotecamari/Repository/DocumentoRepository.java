package projeto.Mari.Biblioteca.repository;

import projeto.Mari.Biblioteca.entity.Documento;
import org.springframework.data.repository.ListCrudRepository;

public interface DocumentoRepository extends ListCrudRepository<Documento,Long> {
    
}
