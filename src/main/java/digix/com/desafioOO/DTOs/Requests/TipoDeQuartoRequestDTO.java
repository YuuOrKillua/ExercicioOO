package digix.com.desafioOO.DTOs.Requests;

import java.math.BigDecimal;

public record TipoDeQuartoRequestDTO(
    String nome,
    BigDecimal valor
) {

}
