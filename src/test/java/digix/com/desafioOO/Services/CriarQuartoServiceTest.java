package digix.com.desafioOO.Services;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import digix.com.desafioOO.DTOs.Requests.QuartoRequestDTO;
import digix.com.desafioOO.DTOs.Responses.QuartoResponseDTO;
import digix.com.desafioOO.Models.TipoDeQuarto;
import digix.com.desafioOO.Repository.TipoDeQuartoRepository;

@SpringBootTest
public class CriarQuartoServiceTest {

    @Autowired
    CriarQuartoService criarQuartoService;

    @Autowired
    TipoDeQuartoRepository tipoDeQuartoRepository;

    @Test
    void deve_criar_um_quarto_com_um_tipo(){
        //Arrange
        
        //Criando Atributos TipoDeQuarto
        String tipoNome = "fjehb0pdfe";
        BigDecimal tipoValor = new BigDecimal(200);

        //Criando Objeto TipoDeQuarto
        TipoDeQuarto tipoDeQuarto = new TipoDeQuarto(tipoNome, tipoValor);

        //Salvando Objeto TipoDeQuarto
        tipoDeQuartoRepository.save(tipoDeQuarto);

        //Guardando Id do Objeto TipoDeQuarto Salvo
        Long tipoDeQuartoId = tipoDeQuarto.getId();

        //Criando Atributos QuartoResquestDTO
        int numeroDoQuarto = 79;
        String descricao = "jfdhfgdspfkhdes";

        //Criando Objeto QuartoRequestDTO
        QuartoRequestDTO quartoRequestDTO = new QuartoRequestDTO(numeroDoQuarto, descricao, tipoDeQuartoId);

        //Action    
        QuartoResponseDTO quartoResponseDTO = criarQuartoService.criarQuarto(quartoRequestDTO);

        //Assert
        assertThat(quartoResponseDTO.numeroDoQuarto()).isEqualTo(numeroDoQuarto);
        assertThat(quartoResponseDTO.descricao()).isEqualTo(descricao);
        assertThat(quartoResponseDTO.tipo().getId()).isEqualTo(tipoDeQuarto.getId());
        assertThat(quartoResponseDTO.tipo().getNome()).isEqualTo(tipoDeQuarto.getNome());
        assertThat(quartoResponseDTO.tipo().getValor().doubleValue()).isEqualTo(tipoDeQuarto.getValor().doubleValue());
        assertThat(quartoResponseDTO.id()).isNotNull();
    }
}
