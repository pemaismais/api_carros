package app.crud.repository;

import app.crud.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  MarcaRepository extends JpaRepository<Marca,Long> {
}
