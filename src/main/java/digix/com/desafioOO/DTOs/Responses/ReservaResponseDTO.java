package digix.com.desafioOO.DTOs.Responses;

import java.util.List;

import digix.com.desafioOO.Models.Quarto;

public record ReservaResponseDTO(
    Long numeroDaReserva,
    List<Quarto> quartos,
    int data
) {
    
}
