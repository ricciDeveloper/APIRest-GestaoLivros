package API.Domain.Repository;

import API.Domain.Model.Livros;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends CrudRepository<Livros, Long> {

}
