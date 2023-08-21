package digix.com.desafioOO.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import digix.com.desafioOO.Models.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long> {
    
}
