package digix.com.desafioOO.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import digix.com.desafioOO.Models.Quarto;

@Repository
public interface QuartoRepository extends CrudRepository<Quarto, Long> {

}
