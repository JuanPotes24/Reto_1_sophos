package proyecto.sophos.reto1.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto.sophos.reto1.Modelos.Alquiler;
import proyecto.sophos.reto1.Modelos.Clientes;
import proyecto.sophos.reto1.Modelos.Juegos;
import proyecto.sophos.reto1.Modelos.Precio_Alquiler;
import proyecto.sophos.reto1.Repositorios.RepositorioAlquiler;
import proyecto.sophos.reto1.Repositorios.RepositorioCliente;
import proyecto.sophos.reto1.Repositorios.RepositorioJuego;
import proyecto.sophos.reto1.Repositorios.RepositorioPrecioAlquiler;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/alquiler")
public class ControladorAlquiler {

    @Autowired
    RepositorioAlquiler miRepositorioAlquier;

    @Autowired
    RepositorioCliente miRepositorioCliente;

    @Autowired
    RepositorioJuego miRepositorioJuego;

    @Autowired
    RepositorioPrecioAlquiler miRepositorioPrecioAlquiler;



    @GetMapping("")
    public List<Alquiler> index(){
        return miRepositorioAlquier.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Alquiler create(@RequestBody Alquiler infoAlquiler){
        return miRepositorioAlquier.save(infoAlquiler);
    }

    @GetMapping("{id}")
    public Alquiler show(@PathVariable int id){
        Alquiler alquilerActual = this.miRepositorioAlquier
                .findById(id)
                .orElse(null);
        return alquilerActual;
    }

    @PutMapping("{id}")
    public Alquiler update(@PathVariable int id, @RequestBody Alquiler infoAlquiler){
        Alquiler alquilerActual = this.miRepositorioAlquier
                .findById(id)
                .orElse(null);
        if (alquilerActual != null){
            alquilerActual.setFecha_alquiler(infoAlquiler.getFecha_alquiler());
            alquilerActual.setPeriodo_alquiler(infoAlquiler.getPeriodo_alquiler());
            return this.miRepositorioAlquier.save(alquilerActual);
        }   else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Alquiler alquilerActual = this.miRepositorioAlquier
                .findById(id)
                .orElse(null);
        if(alquilerActual != null){
            this.miRepositorioAlquier.delete(alquilerActual);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("id/{id_alquiler}/cliente/{id_cliente}/juego/{id_juego}/precio_alquiler/{id_precio_alquiler}")
    public Alquiler asignarClienteJuegoPrecio(@PathVariable int id_alquiler, @PathVariable int id_cliente,
                                              @PathVariable int id_juego, @PathVariable int id_precio_alquiler){
        Alquiler nuevoAlquier = new Alquiler();
        Alquiler elAlquiler = this.miRepositorioAlquier.findById(id_alquiler).orElse(null);
        Clientes elCliente = this.miRepositorioCliente.findById(id_cliente).orElse(null);
        Juegos elJuego = this.miRepositorioJuego.findById(id_juego).orElse(null);
        Precio_Alquiler elPrecioAlquiler = this.miRepositorioPrecioAlquiler.findById(id_precio_alquiler).orElse(null);
        if(elAlquiler != null && elCliente != null && elJuego != null && elPrecioAlquiler != null){
            nuevoAlquier.setId_alquiler(elAlquiler.getId_alquiler());
            nuevoAlquier.setFecha_alquiler(elAlquiler.getFecha_alquiler());
            nuevoAlquier.setPeriodo_alquiler(elAlquiler.getPeriodo_alquiler());
            nuevoAlquier.setFk_id_cliente(elCliente);
            nuevoAlquier.setFk_id_juego(elJuego);
            nuevoAlquier.setFk_id_precio_alquiler(elPrecioAlquiler);
            return this.miRepositorioAlquier.save(nuevoAlquier);
        } else {
            return null;
        }
    }

    /*
    @GetMapping("/cliente_con_mas_alquileres")
    public Clientes getClienteConMasAlquileres(){
        List<Object[]> resultados = miRepositorioAlquier.findClienteConMasAlquileres();
        if(!resultados.isEmpty()){
            Object[] clienteConMasAlquileres = resultados.get(0);
            return (Clientes) clienteConMasAlquileres[0];
        }
        return null;
    }

     */


}
