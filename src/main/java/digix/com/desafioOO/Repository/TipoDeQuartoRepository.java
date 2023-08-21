package digix.com.desafioOO.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import digix.com.desafioOO.Models.TipoDeQuarto;

@Repository
public interface TipoDeQuartoRepository extends CrudRepository<TipoDeQuarto, Long> {
    
}
