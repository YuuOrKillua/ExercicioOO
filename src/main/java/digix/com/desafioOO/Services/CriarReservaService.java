package digix.com.desafioOO.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digix.com.desafioOO.DTOs.Requests.ReservaRequestDTO;
import digix.com.desafioOO.DTOs.Responses.ReservaResponseDTO;
import digix.com.desafioOO.Models.Quarto;
import digix.com.desafioOO.Models.Reserva;
import digix.com.desafioOO.Repository.QuartoRepository;
import digix.com.desafioOO.Repository.ReservaRepository;

@Service
public class CriarReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    QuartoRepository quartoRepository;

    public ReservaResponseDTO criarReserva(ReservaRequestDTO reservaRequestDTO){
        List<Quarto> quartos = new ArrayList<>();

        for(Long ids : reservaRequestDTO.idQuartos()){
            Optional<Quarto> quartoOptional = quartoRepository.findById(ids);
            Quarto quarto = quartoOptional.get();
            quartos.add(quarto);
        }
        
        Reserva reserva = new Reserva(quartos, reservaRequestDTO.data());
        reservaRepository.save(reserva);
        return new ReservaResponseDTO(reserva.getNumeroDaReserva(), reserva.getQuartos(), reserva.getData());
    }
}
