package proyecto.sophos.reto1.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.sophos.reto1.Modelos.Precio_Alquiler;

@Repository
public interface RepositorioPrecioAlquiler extends JpaRepository<Precio_Alquiler, Integer> {
}
