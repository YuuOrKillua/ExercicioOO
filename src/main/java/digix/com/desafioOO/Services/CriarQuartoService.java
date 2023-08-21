package digix.com.desafioOO.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digix.com.desafioOO.DTOs.Requests.QuartoRequestDTO;
import digix.com.desafioOO.DTOs.Responses.QuartoResponseDTO;
import digix.com.desafioOO.Models.Quarto;
import digix.com.desafioOO.Models.TipoDeQuarto;
import digix.com.desafioOO.Repository.QuartoRepository;
import digix.com.desafioOO.Repository.TipoDeQuartoRepository;

@Service
public class CriarQuartoService {

    @Autowired
    QuartoRepository quartoRepository;

    @Autowired
    TipoDeQuartoRepository tipoDeQuartoRepository;

    public QuartoResponseDTO criarQuarto(QuartoRequestDTO quartoRequestDTO) {
        Optional<TipoDeQuarto> tipoDeQuartoOptional = tipoDeQuartoRepository.findById(quartoRequestDTO.idTipo());
        TipoDeQuarto tipoDeQuarto = tipoDeQuartoOptional.get();
        Quarto quarto = new Quarto(quartoRequestDTO.numeroDoQuarto(), quartoRequestDTO.descricao(), tipoDeQuarto);
        quartoRepository.save(quarto);
        return new QuartoResponseDTO(quarto.getId(), quarto.getNumeroDoQuarto(), quarto.getDescricao(), quarto.getTipo());
    }
}
