package proyecto.sophos.reto1.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.sophos.reto1.Modelos.Juegos;

@Repository
public interface RepositorioJuego extends JpaRepository<Juegos, Integer> {
}
