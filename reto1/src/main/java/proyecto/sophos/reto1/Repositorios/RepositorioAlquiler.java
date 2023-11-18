package proyecto.sophos.reto1.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proyecto.sophos.reto1.Modelos.Alquiler;
import java.util.List;

@Repository
public interface RepositorioAlquiler extends JpaRepository <Alquiler, Integer>{

    /*
    @Query("SELECT a.fk_id_cliente, COUNT(a.fk_id_cliente) AS total_alquileres" +
            "FROM Alquiler a " +
            "GROUP BY a.fk_id_cliente " +
            "ORDER BY total_alquileres DESC")
    List<Object[]> findClienteConMasAlquileres();

     */
}
