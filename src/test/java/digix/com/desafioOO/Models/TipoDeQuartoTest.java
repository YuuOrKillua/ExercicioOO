package digix.com.desafioOO.Models;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class TipoDeQuartoTest {
    
    @Test
    void deve_conter_id_nome_e_valor(){
        //Arrange
        String nome = "Quarto Individual";
        BigDecimal valor = new BigDecimal(200);

        //Action
        TipoDeQuarto tipoDeQuarto = new TipoDeQuarto(nome, valor);
        
        //Assert
        assertThat(tipoDeQuarto.getNome()).isEqualTo(nome);
        assertThat(tipoDeQuarto.getValor()).isEqualTo(valor);
        assertThat(tipoDeQuarto.getId()).isNull();
    }
}
