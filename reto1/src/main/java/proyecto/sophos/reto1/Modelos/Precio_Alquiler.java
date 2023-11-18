package proyecto.sophos.reto1.Modelos;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Precio_Alquiler")
public class Precio_Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_precio_alquiler")
    private int id_precio_alquiler;

    @Column(name = "precio")
    private float precio;

    @OneToOne
    @JoinColumn(name = "fk_id_juego")
    private Juegos fk_id_juego;

}
