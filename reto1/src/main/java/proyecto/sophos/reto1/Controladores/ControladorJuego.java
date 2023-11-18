package proyecto.sophos.reto1.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto.sophos.reto1.Modelos.Juegos;
import proyecto.sophos.reto1.Repositorios.RepositorioJuego;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/juegos")
public class ControladorJuego {

    @Autowired
    private RepositorioJuego miRepositorioJuego;

    @GetMapping("")
    public List<Juegos> index(){
        return miRepositorioJuego.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Juegos create(@RequestBody Juegos infoJuego){
        return miRepositorioJuego.save(infoJuego);
    }

    @GetMapping("{id}")
    public Juegos show(@PathVariable int id){
        Juegos juegoActual = this.miRepositorioJuego
                .findById(id)
                .orElse(null);
        return juegoActual;
    }

    @PutMapping("{id}")
    public Juegos update(@PathVariable int id, @RequestBody Juegos infoJuego){
        Juegos juegoActual = this.miRepositorioJuego
                .findById(id)
                .orElse(null);
        if (juegoActual != null){
            juegoActual.setNombre(infoJuego.getNombre());
            juegoActual.setDirector(infoJuego.getDirector());
            juegoActual.setProductor(infoJuego.getProductor());
            juegoActual.setProtagonistas(infoJuego.getProtagonistas());
            juegoActual.setPlataforma(infoJuego.getPlataforma());
            juegoActual.setFecha_lanzamiento((infoJuego.getFecha_lanzamiento()));
            return this.miRepositorioJuego.save(juegoActual);
        }   else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Juegos juegoActual = this.miRepositorioJuego
                .findById(id)
                .orElse(null);
        if(juegoActual != null){
            this.miRepositorioJuego.delete(juegoActual);
        }
    }

}
