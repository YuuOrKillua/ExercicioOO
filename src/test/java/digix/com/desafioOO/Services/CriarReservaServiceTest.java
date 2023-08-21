package digix.com.desafioOO.Services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import digix.com.desafioOO.DTOs.Requests.QuartoRequestDTO;
import digix.com.desafioOO.DTOs.Requests.ReservaRequestDTO;
import digix.com.desafioOO.DTOs.Responses.QuartoResponseDTO;
import digix.com.desafioOO.DTOs.Responses.ReservaResponseDTO;
import digix.com.desafioOO.Models.Quarto;
import digix.com.desafioOO.Models.TipoDeQuarto;
import digix.com.desafioOO.Repository.QuartoRepository;
import digix.com.desafioOO.Repository.TipoDeQuartoRepository;

@SpringBootTest
public class CriarReservaServiceTest {
    
    @Autowired
    CriarReservaService criarReservaService;

    @Autowired
    QuartoRepository quartoRepository;

    @Autowired
    TipoDeQuartoRepository tipoDeQuartoRepository;

    @Autowired
    CriarQuartoService criarQuartoService;

    @Test
    void deve_criar_uma_reserva_de_quartos_com_data(){
        //Arrange

        //Criando Atributos TipoDeQuarto
        String tipoDeQuartoNome1 = "kvghdfpodef";
        BigDecimal tipoDeQuartoValor1 = new BigDecimal(999);
        String tipoDeQuartoNome2 = "ffsfsfsdfsd";
        BigDecimal tipoDeQuartoValor2 = new BigDecimal(777);

        //Criando Objetos TipoDeQuarto
        TipoDeQuarto tipoDeQuarto1 = new TipoDeQuarto(tipoDeQuartoNome1, tipoDeQuartoValor1);
        TipoDeQuarto tipoDeQuarto2 = new TipoDeQuarto(tipoDeQuartoNome2, tipoDeQuartoValor2);

        //Salvando Objetos TipoDeQuarto
        tipoDeQuartoRepository.save(tipoDeQuarto1);
        tipoDeQuartoRepository.save(tipoDeQuarto2);

        //Guardando Ids dos Objetos TipoDeQuarto Salvos
        Long tipoDeQuartoId1 = tipoDeQuarto1.getId();
        Long tipoDeQuartoId2 = tipoDeQuarto2.getId();

        //Criando Atributos QuartoResquestDTO
        int numeroDoQuarto1 = 213;
        String descricaoDoQuarto1 = "fduihdfpdffjeiofef";
        int numeroDoQuarto2 = 908;
        String descricaoDoQuarto2 = "fdgdfgdgfrerru";

        //Criando Objetos QuartoRequestDTO
        QuartoRequestDTO quartoRequestDTO1 = new QuartoRequestDTO(numeroDoQuarto1, descricaoDoQuarto1, tipoDeQuartoId1);
        QuartoRequestDTO quartoRequestDTO2 = new QuartoRequestDTO(numeroDoQuarto2, descricaoDoQuarto2, tipoDeQuartoId2);

        //Passando Pelo CriarQuartoService e Devolvendo Em QuartoResponseDTO
        QuartoResponseDTO quartoResponseDTO1 = criarQuartoService.criarQuarto(quartoRequestDTO1);
        QuartoResponseDTO quartoResponseDTO2 = criarQuartoService.criarQuarto(quartoRequestDTO2);

        //Transformando Objetos QuartoResponseDTO Para Objetos Quarto
        Optional<Quarto> quartoOptional1 = quartoRepository.findById(quartoResponseDTO1.id());
        Quarto quarto1 = quartoOptional1.get();
        Optional<Quarto> quartoOptional2 = quartoRepository.findById(quartoResponseDTO2.id());
        Quarto quarto2 = quartoOptional2.get();

        //Salvando Uma Lista De Objetos Quarto
        List<Quarto> quartos = new ArrayList<>(); 
        quartos.add(quarto1);
        quartos.add(quarto2);

        //Criando Atributos Para Objeto ReservaRequestDTO
        int data = 8;

        //Salvando Uma Lista de Ids
        List<Long> idQuartos = new ArrayList<>();
        idQuartos.add(quarto1.getId());
        idQuartos.add(quarto2.getId());

        //Criando Objeto ReservaRequestDTO
        ReservaRequestDTO reservaRequestDTO = new ReservaRequestDTO(idQuartos, data);

        //Action
        ReservaResponseDTO reservaResponseDTO = criarReservaService.criarReserva(reservaRequestDTO);
        
        //Assert
        assertThat(reservaResponseDTO.data()).isEqualTo(data);
        assertThat(reservaResponseDTO.numeroDaReserva()).isNotNull();
        System.out.println(reservaResponseDTO.quartos().stream().map(Quarto :: getNumeroDoQuarto));
        System.out.println("IDs na stream atual: " + reservaResponseDTO.quartos().stream().map(Quarto::getTipo).map(TipoDeQuarto::getId).collect(Collectors.toList()));
        System.out.println("IDs na stream esperada: " + quartos.stream().map(Quarto::getTipo).map(TipoDeQuarto::getId).collect(Collectors.toList()));
        assertThat(reservaResponseDTO.quartos().stream().map(Quarto :: getTipo).map(TipoDeQuarto :: getId)).isEqualTo(quartos.stream().map(Quarto :: getTipo).map(TipoDeQuarto :: getId));
        assertThat(reservaResponseDTO.quartos().stream().map(Quarto :: getTipo).map(TipoDeQuarto :: getNome)).isEqualTo(quartos.stream().map(Quarto :: getTipo).map(TipoDeQuarto :: getNome));
        assertThat(reservaResponseDTO.quartos().stream().map(Quarto :: getTipo).map(TipoDeQuarto :: getValor)).isEqualTo(quartos.stream().map(Quarto :: getTipo).map(TipoDeQuarto :: getValor));
        assertThat(reservaResponseDTO.quartos().stream().map(Quarto :: getNumeroDoQuarto)).isEqualTo(quartos.stream().map(Quarto :: getNumeroDoQuarto));
        assertThat(reservaResponseDTO.quartos().stream().map(Quarto :: getDescricao)).isEqualTo(quartos.stream().map(Quarto :: getDescricao));
        assertThat(reservaResponseDTO.quartos().stream().map(Quarto :: getId)).isEqualTo(quartos.stream().map(Quarto :: getId));

    }
}
