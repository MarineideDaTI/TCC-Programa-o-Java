package projeto.Mari.Biblioteca.repository;

import projeto.Mari.Biblioteca.entity.Circulacao;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CirculacaoRepository extends ListCrudRepository<Circulacao,Long> {


}
