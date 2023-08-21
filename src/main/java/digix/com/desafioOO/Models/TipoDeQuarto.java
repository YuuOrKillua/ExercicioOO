package digix.com.desafioOO.Models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "tipo_de_quartos")
@Entity
@Getter
public class TipoDeQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    BigDecimal valor;

    protected TipoDeQuarto(){

    }
    public TipoDeQuarto(String nome, BigDecimal valor){
        this.nome = nome;
        this.valor = valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
