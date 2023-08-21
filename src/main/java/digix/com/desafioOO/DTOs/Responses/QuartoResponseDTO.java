package digix.com.desafioOO.DTOs.Responses;

import digix.com.desafioOO.Models.TipoDeQuarto;

public record QuartoResponseDTO(
    Long id,
    int numeroDoQuarto,
    String descricao,
    TipoDeQuarto tipo
) {
    
}
