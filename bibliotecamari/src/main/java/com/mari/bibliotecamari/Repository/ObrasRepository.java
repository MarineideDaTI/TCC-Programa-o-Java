package projeto.Mari.Biblioteca.repository;

import org.springframework.data.repository.ListCrudRepository;
import projeto.Mari.Biblioteca.entity.Imprenta;

public interface ObrasRepository extends ListCrudRepository<Imprenta,Long> {

    
}
