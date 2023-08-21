package digix.com.desafioOO.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "reservas")
@Entity
@Getter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numeroDaReserva;
    @ManyToMany
    List<Quarto> quartos;
    int data;

    protected Reserva(){

    }

    public Reserva(List<Quarto> quartos, int data){
        this.quartos = quartos;
        this.data = data;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    public void setData(int data) {
        this.data = data;
    }
}
