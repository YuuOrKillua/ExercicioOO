package digix.com.desafioOO.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Table(name = "quartos")
@Entity
@Getter
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int numeroDoQuarto;
    String descricao;

    @ManyToOne
    TipoDeQuarto tipo;

    protected Quarto(){

    }

    public Quarto(int numeroDoQuarto, String descricao, TipoDeQuarto tipo){
        this.numeroDoQuarto = numeroDoQuarto;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public void setNumeroDoQuarto(int numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipo(TipoDeQuarto tipo) {
        this.tipo = tipo;
    }
}
