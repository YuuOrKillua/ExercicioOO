package digix.com.desafioOO.Models;


import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class QuartoTest {
    
    @Test
    void deve_conter_numero_do_quarto_descricao_e_tipo(){
        //Arrange
        String tipoNome = "fdgdfgdf";
        BigDecimal tipoValor = new BigDecimal(200);

        int numeroDoQuarto = 498;
        String descricao = "jdbfdeioufbdodeboedbvedo";
        TipoDeQuarto tipo = new TipoDeQuarto(tipoNome, tipoValor);

        //Action
        Quarto quarto = new Quarto(numeroDoQuarto, descricao, tipo);

        //Assert
        assertThat(quarto.getNumeroDoQuarto()).isEqualTo(numeroDoQuarto);
        assertThat(quarto.getDescricao()).isEqualTo(descricao);
        assertThat(quarto.getTipo()).isEqualTo(tipo);
    }

    @Test
    void deve_receber_numeroDoQuarto_nulo_e_devolver_um_exception(){

    }
}
