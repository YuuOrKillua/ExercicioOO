package digix.com.desafioOO.DTOs.Responses;

import java.math.BigDecimal;

public record TipoDeQuartoResponseDTO(
    Long id,
    String nome,
    BigDecimal valor
) {
    
}
