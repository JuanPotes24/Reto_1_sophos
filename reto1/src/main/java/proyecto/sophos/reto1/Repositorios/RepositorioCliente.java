package proyecto.sophos.reto1.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.sophos.reto1.Modelos.Clientes;

@Repository
public interface RepositorioCliente extends JpaRepository<Clientes, Integer> {


}
