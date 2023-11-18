package proyecto.sophos.reto1.Modelos;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Alquiler")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private int id_alquiler;

    @Column(name = "fecha_alquiler")
    private LocalDate fecha_alquiler;

    @Column(name = "periodo_alquiler")
    private LocalDate periodo_alquiler;

    @ManyToOne
    @JoinColumn(name = "fk_id_cliente")
    private Clientes fk_id_cliente;

    @ManyToOne
    @JoinColumn(name = "fk_id_juego")
    private Juegos fk_id_juego;

    @ManyToOne
    @JoinColumn(name = "fk_id_precio_alquiler")
    private Precio_Alquiler fk_id_precio_alquiler;
}
