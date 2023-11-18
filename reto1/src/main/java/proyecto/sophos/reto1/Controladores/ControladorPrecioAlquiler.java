package proyecto.sophos.reto1.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto.sophos.reto1.Modelos.Juegos;
import proyecto.sophos.reto1.Modelos.Precio_Alquiler;
import proyecto.sophos.reto1.Repositorios.RepositorioJuego;
import proyecto.sophos.reto1.Repositorios.RepositorioPrecioAlquiler;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/precio_alquiler")
public class ControladorPrecioAlquiler {

    @Autowired
    private RepositorioPrecioAlquiler miRepositorioPrecioAlquiler;

    @Autowired
    private RepositorioJuego miRepositorioJuego;

    @GetMapping("")
    public List<Precio_Alquiler> index(){
        return miRepositorioPrecioAlquiler.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Precio_Alquiler create(@RequestBody Precio_Alquiler infoPrecioAlquiler){
        return miRepositorioPrecioAlquiler.save(infoPrecioAlquiler);
    }

    @GetMapping("{id}")
    public Precio_Alquiler show(@PathVariable int id){
        Precio_Alquiler precio_Alquiler_Actual = this.miRepositorioPrecioAlquiler
                .findById(id)
                .orElse(null);
        return precio_Alquiler_Actual;
    }

    @PutMapping("{id}")
    public Precio_Alquiler update(@PathVariable int id, @RequestBody Precio_Alquiler infoPrecioAlquiler){
        Precio_Alquiler precio_Alquiler_Actual = this.miRepositorioPrecioAlquiler
                .findById(id)
                .orElse(null);
        if (precio_Alquiler_Actual != null){
            precio_Alquiler_Actual.setPrecio(infoPrecioAlquiler.getPrecio());
            return this.miRepositorioPrecioAlquiler.save(precio_Alquiler_Actual);
        }   else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Precio_Alquiler precio_Alquiler_Actual = this.miRepositorioPrecioAlquiler
                .findById(id)
                .orElse(null);
        if(precio_Alquiler_Actual != null){
            this.miRepositorioPrecioAlquiler.delete(precio_Alquiler_Actual);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("id/{id_precio_alquiler}/juego/{id_juego}")
    public Precio_Alquiler asignarJuego(@PathVariable int id_precio_alquiler, @PathVariable int id_juego){
        Precio_Alquiler nuevoPrecioAlquiler = new Precio_Alquiler();
        Precio_Alquiler elPrecioAlquiler = this.miRepositorioPrecioAlquiler.findById(id_precio_alquiler).orElse(null);
        Juegos elJuego = this.miRepositorioJuego.findById(id_juego).orElse(null);
        if(elPrecioAlquiler != null && elJuego != null){
            nuevoPrecioAlquiler.setId_precio_alquiler(elPrecioAlquiler.getId_precio_alquiler());
            nuevoPrecioAlquiler.setPrecio(elPrecioAlquiler.getPrecio());
            nuevoPrecioAlquiler.setFk_id_juego(elJuego);
            return this.miRepositorioPrecioAlquiler.save(nuevoPrecioAlquiler);
        }   else {
            return null;
        }
    }
}
