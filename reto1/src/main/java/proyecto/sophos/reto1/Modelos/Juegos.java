package proyecto.sophos.reto1.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Juegos")

public class Juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juego")
    private int id_juego;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "director")
    private String director;

    @Column(name = "protagonistas")
    private String protagonistas;

    @Column(name = "productor")
    private String productor;

    @Column(name = "fecha_lanzamiento")
    private LocalDate fecha_lanzamiento;

    @Column(name = "plataforma")
    private String plataforma;
}
