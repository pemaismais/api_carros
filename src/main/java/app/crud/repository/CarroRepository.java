package app.crud.repository;

import app.crud.entity.Carro;
import app.crud.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    public List<Carro> findByModelo(String nome);

    @Query("SELECT c FROM Carro c WHERE c.ano > :ano")
    public List<Carro> findAcimaAno(int ano);

    public List<Carro> findByMarca(Marca marca);
}
