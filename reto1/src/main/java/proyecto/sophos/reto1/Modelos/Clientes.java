package proyecto.sophos.reto1.Modelos;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int id_cliente;

    @Column(name = "cedula")
    private int cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @Column(name = "fecha_registro")
    private LocalDate fecha_registro;



}
