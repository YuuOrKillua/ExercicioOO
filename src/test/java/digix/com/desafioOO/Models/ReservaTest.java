package digix.com.desafioOO.Models;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ReservaTest {
    
    @Test
    void deve_conter_lista_de_quartos_com_data(){
        //Arrange
        String tipoNome1 = "jbeovbefdvdfv";
        BigDecimal tipoValor1 = new BigDecimal(999);
        String tipoNome2 = "ffsfsfsdfsd";
        BigDecimal tipoValor2 = new BigDecimal(777);

        int numeroDoQuarto1 = 213;
        String descricao1 = "fduihdfpdffjeiofef";
        TipoDeQuarto tipo1 = new TipoDeQuarto(tipoNome1, tipoValor1);
        int numeroDoQuarto2 = 908;
        String descricao2 = "fdgdfgdgfrerru";
        TipoDeQuarto tipo2 = new TipoDeQuarto(tipoNome2, tipoValor2);

        Quarto quarto1 = new Quarto(numeroDoQuarto1, descricao1, tipo1);
        Quarto quarto2 = new Quarto(numeroDoQuarto2, descricao2, tipo2);

        List<Quarto> quartos = new ArrayList<>();
        quartos.add(quarto1);
        quartos.add(quarto2);
        int data = 8;

        //Action
        Reserva reserva = new Reserva(quartos, data);

        //Assert
        assertThat(reserva.getQuartos()).isEqualTo(quartos);
        assertThat(reserva.getData()).isEqualTo(data);
        assertThat(reserva.getNumeroDaReserva()).isNull();

    }
}
