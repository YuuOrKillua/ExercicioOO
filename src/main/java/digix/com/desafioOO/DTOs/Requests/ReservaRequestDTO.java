package digix.com.desafioOO.DTOs.Requests;

import java.util.List;

public record ReservaRequestDTO(
    List<Long> idQuartos,
    int data
) {
    
}
