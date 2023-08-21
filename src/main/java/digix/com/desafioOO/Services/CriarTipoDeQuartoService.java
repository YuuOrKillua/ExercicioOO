package digix.com.desafioOO.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digix.com.desafioOO.DTOs.Requests.TipoDeQuartoRequestDTO;
import digix.com.desafioOO.DTOs.Responses.TipoDeQuartoResponseDTO;
import digix.com.desafioOO.Models.TipoDeQuarto;
import digix.com.desafioOO.Repository.TipoDeQuartoRepository;

@Service
public class CriarTipoDeQuartoService {
    
    @Autowired
    TipoDeQuartoRepository tipoDeQuartoRepository;

    public TipoDeQuartoResponseDTO criarTipoDeQuarto( TipoDeQuartoRequestDTO tipoDeQuartoRequestDTO){
        TipoDeQuarto tipoDeQuarto = new TipoDeQuarto(tipoDeQuartoRequestDTO.nome(), tipoDeQuartoRequestDTO.valor());
        tipoDeQuartoRepository.save(tipoDeQuarto);
        return new TipoDeQuartoResponseDTO(tipoDeQuarto.getId(), tipoDeQuarto.getNome(), tipoDeQuarto.getValor());
    }

}
