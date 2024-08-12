package app.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String modelo;
    private int ano;

    // varios carros podem ter 1 marca
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("carros")
    private Marca marca;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "carro_proprietario"
    )
    @JsonIgnoreProperties("carros")
    private List<Proprietario> proprietarios;

}
