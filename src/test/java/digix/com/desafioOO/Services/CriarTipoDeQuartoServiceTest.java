package digix.com.desafioOO.Services;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import digix.com.desafioOO.DTOs.Requests.TipoDeQuartoRequestDTO;
import digix.com.desafioOO.DTOs.Responses.TipoDeQuartoResponseDTO;

@SpringBootTest
public class CriarTipoDeQuartoServiceTest {

    @Autowired
    CriarTipoDeQuartoService criarTipoDeQuartoService;
    
    @Test
    void criar_tipo_de_quarto(){
        //Arrange

        //Criando Atributos TipoDeQuarto
        String nome = "fjehb0pdfe";
        BigDecimal valor = new BigDecimal(200);

        //Criando Objeto TipoDeQuarto
        TipoDeQuartoRequestDTO tipoDeQuartoRequestDTO = new TipoDeQuartoRequestDTO(nome, valor);

        //Action
        TipoDeQuartoResponseDTO tipoDeQuartoResponseDTO = criarTipoDeQuartoService.criarTipoDeQuarto(tipoDeQuartoRequestDTO);

        //Assert
        assertThat(tipoDeQuartoResponseDTO.nome()).isEqualTo(nome);
        assertThat(tipoDeQuartoResponseDTO.valor()).isEqualTo(valor);
        assertThat(tipoDeQuartoResponseDTO.id()).isNotNull();
    }

}
