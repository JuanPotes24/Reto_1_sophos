package proyecto.sophos.reto1.Controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proyecto.sophos.reto1.Modelos.Clientes;
import proyecto.sophos.reto1.Repositorios.RepositorioCliente;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ControladorCliente {
    @Autowired
    private RepositorioCliente miRepositorioCliente;

    @GetMapping("")
    public List<Clientes> index(){
        return miRepositorioCliente.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Clientes create(@RequestBody Clientes infoCliente){
        return miRepositorioCliente.save(infoCliente);
    }

    @GetMapping("{id}")
    public Clientes show(@PathVariable int id){
        Clientes clienteActual = this.miRepositorioCliente
                .findById(id)
                .orElse(null);
        return clienteActual;
    }

    @PutMapping("{id}")
    public Clientes update(@PathVariable int id, @RequestBody Clientes infoCliente){
        Clientes clienteActual = this.miRepositorioCliente
                .findById(id)
                .orElse(null);
        if (clienteActual != null){
            clienteActual.setCedula(infoCliente.getCedula());
            clienteActual.setNombre(infoCliente.getNombre());
            clienteActual.setApellido(infoCliente.getApellido());
            clienteActual.setFecha_nacimiento(infoCliente.getFecha_nacimiento());
            clienteActual.setFecha_registro(infoCliente.getFecha_registro());
            return this.miRepositorioCliente.save(clienteActual);
        }   else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Clientes clienteActual = this.miRepositorioCliente
                .findById(id)
                .orElse(null);
        if(clienteActual != null){
            this.miRepositorioCliente.delete(clienteActual);
        }
    }



}
